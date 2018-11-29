Feature: RTP Incoming Payments Business Validation

Example creditor business validations of incoming RTP Credit Transfer Messages


#=======================================================================================================================
Background: 

Given I am a Creditor FI identified by the routing and transit number "020010001"

And I have the following customer bank accounts:
| Account Number    | Account Type | Account Status | Account Holder First Name | Account Holder Last Name |
| 12000194212199001 | Checking     | Open           | Michel                    | Bisset                   |
| 12000194212199002 | Savings      | Open           | Maria                     | Gonzales                 |
| 12000194212199003 | Checking     | Closed         | Antonio                   | Nguyen                   |
| 12000194212199004 | Retirement   | Open           | Sankar                    | Shaw                     |
| 12000194212199005 | Checking     | Blocked        | Catherine                 | Smith                    |

And the current date and time is "2018-11-12T11:27:00" ET
           

#=======================================================================================================================
Scenario: RTP_CBPV_00 - Valid payment 

Given I receive the following Credit Transfer Message:
| Message Id                          | Creation Date Time  | Number of Transactions | Payment Amount | Payment Currency | Creditor Id | Creditor Account  | Settlement Method |
| M2018111511021200201BFFF00000000001 | 2018-11-12T10:05:00 | 1                      | 512.23         | USD              | 020010001   | 12000194212199001 | CLRG              |

When I validate the Credit Transfer Message

Then I expect no validation errors


#=======================================================================================================================
Scenario: RTP_CBPV_01 - Credit Transfer Message creation date must be within 1 calendar day of current processing date and time

Given I receive the following Credit Transfer Message:
| Message Id                          | Creation Date Time  | Number of Transactions | Payment Amount | Payment Currency | Creditor Id | Creditor Account  | Settlement Method |
| M2018111511021200201BFFF00000000001 | 2018-11-11T11:26:00 | 1                      | 512.23         | USD              | 020010001   | 12000194212199001 | CLRG              |

When I validate the Credit Transfer Message

Then I expect the following validation errors:
| RTP Reject Reason Code | Error Message                                             | 
| DT04                   | Message creation date is outside of valid date range      | 


#=======================================================================================================================
Scenario: RTP_CBPV_02a - Credit Transfer Message must represent a single transaction - More than one transaction

Given I receive the following Credit Transfer Message:
| Message Id                          | Creation Date Time  | Number of Transactions | Payment Amount | Payment Currency | Creditor Id | Creditor Account  | Settlement Method |
| M2018111511021200201BFFF00000000001 | 2018-11-12T10:05:00 | 4                      | 512.23         | USD              | 020010001   | 12000194212199001 | CLRG              |

When I validate the Credit Transfer Message

Then I expect the following validation errors:
| RTP Reject Reason Code | Error Message                                             | 
| 650                    | Number of transactions on message was not 1               | 


#=======================================================================================================================
Scenario: RTP_CBPV_02b - Credit Transfer Message must represent a single transaction - No transactions

Given I receive the following Credit Transfer Message:
| Message Id                          | Creation Date Time  | Number of Transactions | Payment Amount | Payment Currency | Creditor Id | Creditor Account  | Settlement Method |
| M2018111511021200201BFFF00000000001 | 2018-11-12T10:05:00 | 0                      | 512.23         | USD              | 020010001   | 12000194212199001 | CLRG              |

When I validate the Credit Transfer Message

Then I expect the following validation errors:
| RTP Reject Reason Code | Error Message                                             | 
| 650                    | Number of transactions on message was not 1               | 


#=======================================================================================================================
Scenario: RTP_CBPV_03 - Payment amount must be positive

Given I receive the following Credit Transfer Message:
| Message Id                          | Creation Date Time  | Number of Transactions | Payment Amount | Payment Currency | Creditor Id | Creditor Account  | Settlement Method |
| M2018111511021200201BFFF00000000001 | 2018-11-12T10:05:00 | 1                      | -512.23        | USD              | 020010001   | 12000194212199001 | CLRG              |

When I validate the Credit Transfer Message

Then I expect the following validation errors:
| RTP Reject Reason Code | Error Message                                             | 
| 650                    | Payment amount less than or equal to zero                 | 


#=======================================================================================================================
Scenario: RTP_CBPV_04 - Payment currency must be in US Dollars

Given I receive the following Credit Transfer Message:
| Message Id                          | Creation Date Time  | Number of Transactions | Payment Amount | Payment Currency | Creditor Id | Creditor Account  | Settlement Method |
| M2018111511021200201BFFF00000000001 | 2018-11-12T10:05:00 | 1                      | 512.23         | AUD              | 020010001   | 12000194212199001 | CLRG              |

When I validate the Credit Transfer Message

Then I expect the following validation errors:
| RTP Reject Reason Code | Error Message                                             | 
| 650                    | Payment currency code is not valid                        | 


#=======================================================================================================================
Scenario: RTP_CBPV_05 - Incorrect Creditor

Given I receive the following Credit Transfer Message:
| Message Id                          | Creation Date Time  | Number of Transactions | Payment Amount | Payment Currency | Creditor Id | Creditor Account  | Settlement Method |
| M2018111511021200201BFFF00000000001 | 2018-11-12T10:05:00 | 1                      | 512.23         | USD              | 020010002   | 12000194212199001 | CLRG              |

When I validate the Credit Transfer Message

Then I expect the following validation errors:
| RTP Reject Reason Code | Error Message                                             | 
| BE17                   | Creditor identification is not valid                      | 


#=======================================================================================================================
Scenario: RTP_CBPV_06 - Account to be credited must exist 

Given I receive the following Credit Transfer Message:
| Message Id                          | Creation Date Time  | Number of Transactions | Payment Amount | Payment Currency | Creditor Id | Creditor Account  | Settlement Method |
| M2018111511021200201BFFF00000000001 | 2018-11-12T10:05:00 | 1                      | 512.23         | USD              | 020010001   | 12000194212199017 | CLRG              |

When I validate the Credit Transfer Message

Then I expect the following validation errors:
| RTP Reject Reason Code | Error Message                                             | 
| AC03                   | Account number is not valid                               | 


#=======================================================================================================================
Scenario: RTP_CBPV_07 - Account to be credited must open

Given I receive the following Credit Transfer Message:
| Message Id                          | Creation Date Time  | Number of Transactions | Payment Amount | Payment Currency | Creditor Id | Creditor Account  | Settlement Method |
| M2018111511021200201BFFF00000000001 | 2018-11-12T10:05:00 | 1                      | 512.23         | USD              | 020010001   | 12000194212199007 | CLRG              |

When I validate the Credit Transfer Message

Then I expect the following validation errors:
| RTP Reject Reason Code | Error Message                                             | 
| AC04                   | Account number specified has been closed                  | 


#=======================================================================================================================
Scenario: RTP_CBPV_07 - Account to be credited must not be blocked for payments

Given I receive the following Credit Transfer Message:
| Message Id                          | Creation Date Time  | Number of Transactions | Payment Amount | Payment Currency | Creditor Id | Creditor Account  | Settlement Method |
| M2018111511021200201BFFF00000000001 | 2018-11-12T10:05:00 | 1                      | 512.23         | USD              | 020010001   | 12000194212199005 | CLRG              |

When I validate the Credit Transfer Message

Then I expect the following validation errors:
| RTP Reject Reason Code | Error Message                                             | 
| AC06                   | Account number specified is blocked                       | 


#=======================================================================================================================
Scenario: RTP_CBPV_08 - Settlement Method must be CLRG

Given I receive the following Credit Transfer Message:
| Message Id                          | Creation Date Time  | Number of Transactions | Payment Amount | Payment Currency | Creditor Id | Creditor Account  | Settlement Method |
| M2018111511021200201BFFF00000000001 | 2018-11-12T10:05:00 | 1                      | 512.23         | USD              | 020010001   | 12000194212199005 | CLRD              |

When I validate the Credit Transfer Message

Then I expect the following validation errors:
| RTP Reject Reason Code | Error Message                                             | 
| AC06                   | Settlement method is invalid                              | 


#=======================================================================================================================
Scenario: RTP_CBPV_09 - Multiple validation errors

Given I receive the following Credit Transfer Message:
| Message Id                          | Creation Date Time  | Number of Transactions | Payment Amount | Payment Currency | Creditor Id | Creditor Account  | Settlement Method |
| M2018111511021200201BFFF00000000001 | 2017-11-12T10:05:00 | -3                     | 0.00           | GBP              | 020010001   | 12000194212199011 | CLRG              |

When I validate the Credit Transfer Message

Then I expect the following validation errors:
| RTP Reject Reason Code | Error Message                                             | 
| DT04                   | Message creation date is outside of valid date range      | 
| 650                    | Number of transactions on message was not 1               | 
| 650                    | Payment amount less than or equal to zero                 | 
| 650                    | Payment currency code is not valid                        | 
| AC03                   | Account number is not valid                               | 

  