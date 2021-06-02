package server.Server.Model;

import java.io.Serializable;

public class TokenIssued implements Serializable {
    private String tokenValue;

    public TokenIssued(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }
}

