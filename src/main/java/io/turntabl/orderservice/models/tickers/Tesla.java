package io.turntabl.orderservice.models.tickers;

import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "tesla",createIndex = true)
@NoArgsConstructor
public class Tesla extends Ticker{

    public Tesla(String product, String side, double price, int quantity, String exchangeURL) {
        super(product, side, price, quantity, exchangeURL);
    }

}
