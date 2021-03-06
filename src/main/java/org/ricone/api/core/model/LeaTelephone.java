package org.ricone.api.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;

@Entity
@Table(name = "leatelephone")
@JsonInclude(value = Include.NON_EMPTY)
public class LeaTelephone implements java.io.Serializable {
    private static final long serialVersionUID = -2033689116210795367L;
    private String leatelephoneRefId;
    private Lea lea;
    private String telephoneNumber;
    private Boolean primaryTelephoneNumberIndicator;
    private String telephoneNumberTypeCode;

    public LeaTelephone() {
    }

    public LeaTelephone(String leatelephoneRefId, Lea lea) {
        this.leatelephoneRefId = leatelephoneRefId;
        this.lea = lea;
    }

    public LeaTelephone(String leatelephoneRefId, Lea lea, String telephoneNumber, Boolean primaryTelephoneNumberIndicator, String telephoneNumberTypeCode) {
        this.leatelephoneRefId = leatelephoneRefId;
        this.lea = lea;
        this.telephoneNumber = telephoneNumber;
        this.primaryTelephoneNumberIndicator = primaryTelephoneNumberIndicator;
        this.telephoneNumberTypeCode = telephoneNumberTypeCode;
    }

    @Id
    @Column(name = "LEATelephoneRefId", unique = true, nullable = false, length = 64)
    public String getLeaTelephoneRefId() {
        return this.leatelephoneRefId;
    }

    public void setLeaTelephoneRefId(String leatelephoneRefId) {
        this.leatelephoneRefId = leatelephoneRefId;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LEARefId", nullable = false)
    public Lea getLea() {
        return this.lea;
    }

    public void setLea(Lea lea) {
        this.lea = lea;
    }

    @Column(name = "TelephoneNumber", length = 24)
    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Column(name = "PrimaryTelephoneNumberIndicator")
    public Boolean getPrimaryTelephoneNumberIndicator() {
        return this.primaryTelephoneNumberIndicator;
    }

    public void setPrimaryTelephoneNumberIndicator(Boolean primaryTelephoneNumberIndicator) {
        this.primaryTelephoneNumberIndicator = primaryTelephoneNumberIndicator;
    }

    @Column(name = "TelephoneNumberTypeCode", length = 50)
    public String getTelephoneNumberTypeCode() {
        return this.telephoneNumberTypeCode;
    }

    public void setTelephoneNumberTypeCode(String telephoneNumberTypeCode) {
        this.telephoneNumberTypeCode = telephoneNumberTypeCode;
    }
}
