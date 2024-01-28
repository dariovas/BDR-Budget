package ch.heig.bdr.budget.depense.domain;

public class DepenseSearchDTO {
    private int pageNo = 1;
    private String beneficiaire;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
