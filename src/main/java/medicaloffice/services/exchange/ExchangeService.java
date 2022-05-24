package medicaloffice.services.exchange;

import medicaloffice.domain.exchange.ExchangeResponse;

public interface ExchangeService {
    ExchangeResponse exchangeRonToEuro(Double amount);
}