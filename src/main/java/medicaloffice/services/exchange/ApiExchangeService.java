package medicaloffice.services.exchange;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import medicaloffice.domain.ExchangeApiResponse;
import medicaloffice.domain.exchange.ExchangeResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("api")
public class ApiExchangeService implements ExchangeService {

    public ExchangeResponse exchangeRonToEuro(Double amount) {
        HttpResponse<ExchangeApiResponse> response = Unirest.get("https://romanian-exchange-rate-bnr-api.herokuapp.com/api/latest")
                .queryString("access_key", "f7dbe1842278-43779b")
                .asObject(ExchangeApiResponse.class);

        if (response.isSuccess()) {
            Double curs = response.getBody().getRates().getEUR();
            return new ExchangeResponse(amount / curs, curs);
        }

        return new ExchangeResponse(amount, 4.9);
    }
}