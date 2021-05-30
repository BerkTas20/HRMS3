package kodlamaio.HRMS.core.adapters;

import org.springframework.stereotype.Component;

import tr.gov.nvi.tckimlik.WS.KPSPublicLocator;

@Component
public class MernisServiceAdapter {

    public boolean isNatIdReal(String TCNO, String name, String surname, short birthYear) {

        try {
            return new KPSPublicLocator().getKPSPublicSoap().TCKimlikNoDogrula(Long.parseLong(TCNO), name, surname, birthYear);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }

    }

}
