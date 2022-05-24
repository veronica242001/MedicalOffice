package medicaloffice.services.exchange;

import medicaloffice.domain.exchange.ExchangeResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("local")
public class LocalExchangeService implements ExchangeService {

    public ExchangeResponse exchangeRonToEuro(Double amount) {
        // Take data from local file and return it
        return new ExchangeResponse(10d, 10d);
    }
}