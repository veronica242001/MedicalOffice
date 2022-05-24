package medicaloffice.domain;

import lombok.Data;
import medicaloffice.domain.exchange.Rates;

@Data
public class ExchangeApiResponse {
    private Rates rates;
}
