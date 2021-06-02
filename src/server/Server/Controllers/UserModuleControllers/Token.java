package server.Server.Controllers.UserModuleControllers;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Token {
    private final String secretKey = "qbeyS2bwIwlxJa5KBTSFkvyYgHc7E5gtzbrMToWUSzw=";
    private TreeMap<String, String> payload;
    private final String subject;

    /**
     * @param subject Who you are issuing login for, this tend to be unique identifier of the token consumer
     *                like email,id,username or something, of String type
     * @param payload Data to be included in the jwt token, of TreeMap type
     * @author Mutoni Uwingeneye Denyse
     * Token controller
     */
    public Token(String subject, TreeMap<String, String> payload) {
        this.payload = payload;
        this.subject = subject;
    }

    /**
     * @return payload data, of TreeMap type
     * @author Mutoni Uwingeneye Denyse
     * Get payload data
     */
    public TreeMap<String, String> getPayload() {
        return payload;
    }

    /**
     * @param payload data to be included in payload, of TreeMap type
     * @return payload data, of TreeMap type
     * @author Mutoni Uwingeneye Denyse
     * Sets payload data
     */
    public void setPayload(TreeMap<String, String> payload) {
        this.payload = payload;
    }

    public String generateJwtToken(long timeForTokenToBeValid, TemporalUnit unit) {
        byte[] secret = Base64.getDecoder().decode(this.secretKey);
        Instant now = Instant.now();
        String jwtToken = "";
        JwtBuilder jwt;
        try {
            jwt = Jwts.builder().setSubject(this.subject);
            //this is adding the claims to the jwt token
            for (Map.Entry<String, String> entry : this.payload.entrySet()) {
                jwt.claim(entry.getKey(), entry.getValue());
            }
            jwtToken = jwt.setIssuedAt(Date.from(now))
                    .setExpiration(Date.from(now.plus(timeForTokenToBeValid, unit)))
                    .signWith(Keys.hmacShaKeyFor(secret))
                    .compact();
        } catch (InvalidKeyException e) {
            throw new InvalidKeyException(e.getMessage());
        }
        return jwtToken;
    }

    /**
     * @param jwt jwt token, of String type
     * @return decoded string, of String type
     * @throws SignatureException  invalid signature exception
     * @throws ExpiredJwtException token expiration exception
     * @author Mutoni Uwingeneye Denyse
     * Decoding jwt token created by Token class, make sure that you
     * decode token created by Token Class so that it will match secret Key
     * If not valid you will get an io.jsonwebtoken.security.SignatureException exception
     */
    public String decodeToken(String jwt) throws SignatureException, ExpiredJwtException {
        byte[] secret = Base64.getDecoder().decode(this.secretKey);
        String results = "";

        results = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(secret))
                .parseClaimsJws(jwt)
                .toString();

        return results;
    }

    /**
     * @param token token to validate, of String type
     * @return boolean that indicates validity of token
     * @author Mutoni Uwingeneye Denyse
     * Validating token, when token is valid it will return true where as token has expired
     * or has invalid signature it will return false
     */

    public boolean isValidToken(String token) {
        String decodedData = "";
        boolean tokenIsValid = false;
        try {
            decodedData = this.decodeToken(token);

            if (decodedData.length() > 1)
                tokenIsValid = true;

        } catch (SignatureException | ExpiredJwtException ignored) {
        }

        return tokenIsValid;
    }
}
