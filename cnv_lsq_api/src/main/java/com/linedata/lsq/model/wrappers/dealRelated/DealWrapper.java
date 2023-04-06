package com.linedata.lsq.model.wrappers.dealRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.linedata.lsq.model.wrappers.facilityRelated.FacilityWrapper;
import com.linedata.lsq.model.wrappers.feeRelated.FeeWrapper;
import com.linedata.ekip.std.services.deal.entity.Deal;
import com.linedata.ekip.std.services.deal.entity.impl.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DealWrapper {

    @JsonIgnore
    private Deal deal;

    private String externalId;
    private String statusCode;
    private String imposedStatusCode;
    private String creationUser;
    private Date creationDate;
    private Long contractId;
    private Long contractIe;
    private String description;
    private String mainCurrencyCode;
    private String servicingCompany;
    private String businessLineCode;
    private String processingAreaCode;
    private String agentId;
    private String agentName;
    private String adminCode;
    private String adminName;
    private String primaryBorrowerId;
    private String primaryBorrowerCode;
    private String primaryBorrowerName;
    private String primaryLender;
    private String primaryLenderCode;
    private List<DealCurrencyImpl> currencyList;
    private List<DealCalendarImpl> calendarList;
    private List<DealRatioImpl> ratioList;
    private List<DealThirdPartyWrapper> thirdPartyList;
    private List<DealRateIndexImpl> rateIndexList;
    private List<FacilityWrapper> facilityList;
    private List<DealLenderWrapper> dealLenderList;
    private List<FeeWrapper> feeList;
    private String autoTransactionFlag;
    private String modelFlag;
    private BigDecimal initialAmount;
    private Date signatureDate;
    private String countryCode;
    private Date endDate;
    private String buyerCreditFlag;
    private String anacreditReference;
    private Long dealId;
    private Long transactionId;
    private String fuctionCode;
    private Long originId;
    private String transactionExternalId;
    private Double minThreshold;
    private BigDecimal minThresholdAmount;
    private String captureMode;
    private String freeStatusCode;
    private String importTemplateFlag;
    private String amendmentFlag;
    private Long modifTransactionId;

    public DealWrapper() {
    }

    public DealWrapper(Deal deal) {
        this.deal = deal;

        this.externalId = deal.getExternalId();
        this.statusCode = deal.getStatusCode();
        this.imposedStatusCode = deal.getImposedStatusCode();
        this.creationUser = deal.getCreationUser();
        this.creationDate = deal.getCreationDate();
        this.contractId = deal.getContractId();
        this.contractIe = deal.getContractIe();
        this.description = deal.getDescription();
        this.mainCurrencyCode = deal.getMainCurrencyCode();
        this.servicingCompany = deal.getServicingCompany();
        this.businessLineCode = deal.getBusinessLineCode();
        this.processingAreaCode = deal.getProcessingAreaCode();
        this.agentId = deal.getAgentId();
        this.agentName = deal.getAgentName();
        this.adminCode = deal.getAdminCode();
        this.adminName = deal.getAdminName();
        this.primaryBorrowerId = deal.getPrimaryBorrowerId();
        this.primaryBorrowerCode = deal.getPrimaryBorrowerCode();
        this.primaryBorrowerName = deal.getPrimaryBorrowerName();
        this.primaryLender = deal.getPrimaryLender();
        this.primaryLenderCode = deal.getPrimaryLenderCode();

        if (deal.getCurrencyList() != null)
            this.currencyList = deal.getCurrencyList().parallelStream().map(dealCurrency -> ((DealCurrencyImpl) dealCurrency)).collect(Collectors.toList());
        if (deal.getCalendarList() != null)
            this.calendarList = deal.getCalendarList().parallelStream().map(dealCalendar -> ((DealCalendarImpl) dealCalendar)).collect(Collectors.toList());
        if (deal.getRatioList() != null)
            this.ratioList = deal.getRatioList().parallelStream().map(dealRatio -> ((DealRatioImpl) dealRatio)).collect(Collectors.toList());
        if (deal.getThirdPartyList() != null)
            this.thirdPartyList = deal.getThirdPartyList().parallelStream().map(DealThirdPartyWrapper::new).collect(Collectors.toList());
        if (deal.getRateIndexList() != null)
            this.rateIndexList = deal.getRateIndexList().parallelStream().map(dealRateIndex -> ((DealRateIndexImpl) dealRateIndex)).collect(Collectors.toList());
        if (deal.getDealLenderList() != null)
            this.dealLenderList = deal.getDealLenderList().parallelStream().map(DealLenderWrapper::new).collect(Collectors.toList());
        if (deal.getFeeList() != null)
            this.feeList = deal.getFeeList().parallelStream().map(FeeWrapper::new).collect(Collectors.toList());

        this.autoTransactionFlag = deal.getAutoTransactionFlag();
        this.modelFlag = deal.getModelFlag();
        this.initialAmount = deal.getInitialAmount();
        this.signatureDate = deal.getSignatureDate();
        this.countryCode = deal.getCountryCode();
        this.endDate = deal.getEndDate();
        this.buyerCreditFlag = deal.getBuyerCreditFlag();
        this.anacreditReference = deal.getAnacreditReference();
        this.dealId = deal.getDealId();
        this.transactionId = deal.getTransactionId();
        this.fuctionCode = deal.getFuctionCode();
        this.originId = deal.getOriginId();
        this.transactionExternalId = deal.getTransactionExternalId();
        this.minThreshold = deal.getMinThreshold();
        this.minThresholdAmount = deal.getMinThresholdAmount();
        this.captureMode = deal.getCaptureMode();
        this.freeStatusCode = deal.getFreeStatusCode();
        this.importTemplateFlag = deal.getImportTemplateFlag();
        this.amendmentFlag = deal.getAmendmentFlag();
        this.modifTransactionId = deal.getModifTransactionId();
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getPrimaryBorrowerName() {
        return this.primaryBorrowerName;
    }

    public void setPrimaryBorrowerName(String primaryBorrowerName) {
        this.primaryBorrowerName = primaryBorrowerName;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getCreationUser() {
        return this.creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getContractId() {
        return this.contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainCurrencyCode() {
        return this.mainCurrencyCode;
    }

    public void setMainCurrencyCode(String mainCurrencyCode) {
        this.mainCurrencyCode = mainCurrencyCode;
    }

    public String getServicingCompany() {
        return this.servicingCompany;
    }

    public void setServicingCompany(String servicingCompany) {
        this.servicingCompany = servicingCompany;
    }

    public String getBusinessLineCode() {
        return this.businessLineCode;
    }

    public void setBusinessLineCode(String businessLineCode) {
        this.businessLineCode = businessLineCode;
    }

    public String getProcessingAreaCode() {
        return this.processingAreaCode;
    }

    public void setProcessingAreaCode(String processingAreaCode) {
        this.processingAreaCode = processingAreaCode;
    }

    public List<DealCurrencyImpl> getCurrencyList() {
        return this.currencyList;
    }

    public void setCurrencyList(List<DealCurrencyImpl> currencyList) {
        this.currencyList = currencyList;
    }

    public List<DealCalendarImpl> getCalendarList() {
        return this.calendarList;
    }

    public void setCalendarList(List<DealCalendarImpl> calendarList) {
        this.calendarList = calendarList;
    }

    public List<DealRatioImpl> getRatioList() {
        return this.ratioList;
    }

    public void setRatioList(List<DealRatioImpl> ratioList) {
        this.ratioList = ratioList;
    }

    public List<DealThirdPartyWrapper> getThirdPartyList() {
        return this.thirdPartyList;
    }

    public void setThirdPartyList(List<DealThirdPartyWrapper> thirdPartyList) {
        this.thirdPartyList = thirdPartyList;
    }

    public List<DealRateIndexImpl> getRateIndexList() {
        return this.rateIndexList;
    }

    public void setRateIndexList(List<DealRateIndexImpl> rateIndexList) {
        this.rateIndexList = rateIndexList;
    }

    public String getAgentId() {
        return this.agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAdminCode() {
        return this.adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getPrimaryBorrowerId() {
        return this.primaryBorrowerId;
    }

    public void setPrimaryBorrowerId(String primaryBorrowerId) {
        this.primaryBorrowerId = primaryBorrowerId;
    }

    public String getPrimaryLender() {
        return this.primaryLender;
    }

    public void setPrimaryLender(String primaryLender) {
        this.primaryLender = primaryLender;
    }

    public List<DealLenderWrapper> getDealLenderList() {
        return this.dealLenderList;
    }

    public void setDealLenderList(List<DealLenderWrapper> dealLenderList) {
        this.dealLenderList = dealLenderList;
    }

    public String getAutoTransactionFlag() {
        return this.autoTransactionFlag;
    }

    public void setAutoTransactionFlag(String autoTransactionFlag) {
        this.autoTransactionFlag = autoTransactionFlag;
    }

    public String getModelFlag() {
        return this.modelFlag;
    }

    public void setModelFlag(String modelFlag) {
        this.modelFlag = modelFlag;
    }

    public BigDecimal getInitialAmount() {
        return this.initialAmount;
    }

    public void setInitialAmount(BigDecimal initialAmount) {
        this.initialAmount = initialAmount;
    }

    public String getAgentName() {
        return this.agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAdminName() {
        return this.adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Date getSignatureDate() {
        return this.signatureDate;
    }

    public void setSignatureDate(Date signatureDate) {
        this.signatureDate = signatureDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<FeeWrapper> getFeeList() {
        return this.feeList;
    }

    public void setFeeList(List<FeeWrapper> feeList) {
        this.feeList = feeList;
    }

    public Long getDealId() {
        return this.dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }

    public String getPrimaryBorrowerCode() {
        return this.primaryBorrowerCode;
    }

    public void setPrimaryBorrowerCode(String primaryBorrowerCode) {
        this.primaryBorrowerCode = primaryBorrowerCode;
    }

    public String getPrimaryLenderCode() {
        return this.primaryLenderCode;
    }

    public void setPrimaryLenderCode(String primaryLenderCode) {
        this.primaryLenderCode = primaryLenderCode;
    }

    public Long getContractIe() {
        return this.contractIe;
    }

    public void setContractIe(Long contractIe) {
        this.contractIe = contractIe;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getBuyerCreditFlag() {
        return this.buyerCreditFlag;
    }

    public void setBuyerCreditFlag(String buyerCreditFlag) {
        this.buyerCreditFlag = buyerCreditFlag;
    }

    public String getAnacreditReference() {
        return this.anacreditReference;
    }

    public void setAnacreditReference(String anacreditReference) {
        this.anacreditReference = anacreditReference;
    }

    public String getFuctionCode() {
        return this.fuctionCode;
    }

    public void setFuctionCode(String fuctionCode) {
        this.fuctionCode = fuctionCode;
    }

    public Long getOriginId() {
        return this.originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public String getImposedStatusCode() {
        return this.imposedStatusCode;
    }

    public void setImposedStatusCode(String imposedStatusCode) {
        this.imposedStatusCode = imposedStatusCode;
    }

    public String getTransactionExternalId() {
        return this.transactionExternalId;
    }

    public void setTransactionExternalId(String transactionExternalId) {
        this.transactionExternalId = transactionExternalId;
    }

    public String getFreeStatusCode() {
        return this.freeStatusCode;
    }

    public void setFreeStatusCode(String freeStatusCode) {
        this.freeStatusCode = freeStatusCode;
    }

    public Double getMinThreshold() {
        return this.minThreshold;
    }

    public void setMinThreshold(Double minThreshold) {
        this.minThreshold = minThreshold;
    }

    public BigDecimal getMinThresholdAmount() {
        return this.minThresholdAmount;
    }

    public void setMinThresholdAmount(BigDecimal minThresholdAmount) {
        this.minThresholdAmount = minThresholdAmount;
    }

    public String getCaptureMode() {
        return this.captureMode;
    }

    public void setCaptureMode(String captureMode) {
        this.captureMode = captureMode;
    }

    public String getAmendmentFlag() {
        return this.amendmentFlag;
    }

    public void setAmendmentFlag(String amendmentFlag) {
        this.amendmentFlag = amendmentFlag;
    }

    public String getImportTemplateFlag() {
        return this.importTemplateFlag;
    }

    public void setImportTemplateFlag(String importTemplateFlag) {
        this.importTemplateFlag = importTemplateFlag;
    }

    public Long getModifTransactionId() {
        return this.modifTransactionId;
    }

    public void setModifTransactionId(Long modifTransactionId) {
        this.modifTransactionId = modifTransactionId;
    }

    public List<FacilityWrapper> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<FacilityWrapper> facilityList) {
        this.facilityList = facilityList;
    }

    @Override
    public String toString() {
        return "DealDetailsMapper{" +
                "externalId='" + externalId + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", imposedStatusCode='" + imposedStatusCode + '\'' +
                ", creationUser='" + creationUser + '\'' +
                ", creationDate=" + creationDate +
                ", contractId=" + contractId +
                ", contractIe=" + contractIe +
                ", description='" + description + '\'' +
                ", mainCurrencyCode='" + mainCurrencyCode + '\'' +
                ", servicingCompany='" + servicingCompany + '\'' +
                ", businessLineCode='" + businessLineCode + '\'' +
                ", processingAreaCode='" + processingAreaCode + '\'' +
                ", agentId='" + agentId + '\'' +
                ", agentName='" + agentName + '\'' +
                ", adminCode='" + adminCode + '\'' +
                ", adminName='" + adminName + '\'' +
                ", primaryBorrowerId='" + primaryBorrowerId + '\'' +
                ", primaryBorrowerCode='" + primaryBorrowerCode + '\'' +
                ", primaryBorrowerName='" + primaryBorrowerName + '\'' +
                ", primaryLender='" + primaryLender + '\'' +
                ", primaryLenderCode='" + primaryLenderCode + '\'' +
                ", currencyList=" + currencyList +
                ", calendarList=" + calendarList +
                ", ratioList=" + ratioList +
                ", thirdPartyList=" + thirdPartyList +
                ", rateIndexList=" + rateIndexList +
                ", facilityList=" + facilityList +
                ", dealLenderList=" + dealLenderList +
                ", feeList=" + feeList +
                ", autoTransactionFlag='" + autoTransactionFlag + '\'' +
                ", modelFlag='" + modelFlag + '\'' +
                ", initialAmount=" + initialAmount +
                ", signatureDate=" + signatureDate +
                ", countryCode='" + countryCode + '\'' +
                ", endDate=" + endDate +
                ", buyerCreditFlag='" + buyerCreditFlag + '\'' +
                ", anacreditReference='" + anacreditReference + '\'' +
                ", dealId=" + dealId +
                ", transactionId=" + transactionId +
                ", fuctionCode='" + fuctionCode + '\'' +
                ", originId=" + originId +
                ", transactionExternalId='" + transactionExternalId + '\'' +
                ", minThreshold=" + minThreshold +
                ", minThresholdAmount=" + minThresholdAmount +
                ", captureMode='" + captureMode + '\'' +
                ", freeStatusCode='" + freeStatusCode + '\'' +
                ", importTemplateFlag='" + importTemplateFlag + '\'' +
                ", amendmentFlag='" + amendmentFlag + '\'' +
                ", modifTransactionId=" + modifTransactionId +
                '}';
    }
}
