//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.07 at 12:45:54 PM EST 
//


package iso.std.iso._20022.tech.xsd.camt_035_001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrtryFrmtInvstgtn" type="{urn:iso:std:iso:20022:tech:xsd:camt.035.001.03}ProprietaryFormatInvestigationV03"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "prtryFrmtInvstgtn"
})
public class Document {

    @XmlElement(name = "PrtryFrmtInvstgtn", required = true)
    protected ProprietaryFormatInvestigationV03 prtryFrmtInvstgtn;

    /**
     * Gets the value of the prtryFrmtInvstgtn property.
     * 
     * @return
     *     possible object is
     *     {@link ProprietaryFormatInvestigationV03 }
     *     
     */
    public ProprietaryFormatInvestigationV03 getPrtryFrmtInvstgtn() {
        return prtryFrmtInvstgtn;
    }

    /**
     * Sets the value of the prtryFrmtInvstgtn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProprietaryFormatInvestigationV03 }
     *     
     */
    public void setPrtryFrmtInvstgtn(ProprietaryFormatInvestigationV03 value) {
        this.prtryFrmtInvstgtn = value;
    }

}
