package TestScenarioPage;

import com.havenlife.vision.BaseFramework.ScriptBase;
import org.testng.annotations.Test;

/**
 * Created by Abdullah on 6/25/17.
 */
public class Scen01 extends ScriptBase{

    @Test (enabled = true)
    public void testInsuranceCalculator(){
        havenLifeInsurance.insuranceCalculator().naviageteToHomepage();
        havenLifeInsurance.insuranceCalculator().InputDateOfBirth("01/01/1967");
        havenLifeInsurance.insuranceCalculator().inputPrimaryIncome("82000");
        havenLifeInsurance.insuranceCalculator().inputZipCode("11435");
        havenLifeInsurance.insuranceCalculator().inputGender("Male");
        havenLifeInsurance.insuranceCalculator().inputFamilyMembers();
        havenLifeInsurance.insuranceCalculator().inputPartnerAge("45");
        havenLifeInsurance.insuranceCalculator().inputPartnerWorks("yes");
        havenLifeInsurance.insuranceCalculator().inputNumberOfKids("1");
        havenLifeInsurance.insuranceCalculator().inputKidsAge("18");
        havenLifeInsurance.insuranceCalculator().inputKidsCollegePayment("not paying for college");
        havenLifeInsurance.insuranceCalculator().inputDebt();
        havenLifeInsurance.insuranceCalculator().inputMortageLoan("55000");
        havenLifeInsurance.insuranceCalculator().clickToViewMyQuoates();
        havenLifeInsurance.insuranceCalculator().validatePolicy();

    }
}
