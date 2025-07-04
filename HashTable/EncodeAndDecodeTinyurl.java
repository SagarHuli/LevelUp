package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 */
public class EncodeAndDecodeTinyurl {

    Map<String,String> encode;
    Map<String,String> decode;
    static String baseUrl = "http://tinyurl.com/";

    public EncodeAndDecodeTinyurl() {
        encode = new HashMap<>();
        decode = new HashMap<>();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(!encode.containsKey(longUrl)) {
            String shortUrl = baseUrl + String.valueOf(encode.size());
            encode.put(longUrl, shortUrl);
            decode.put(shortUrl, longUrl);
        }
        return encode.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decode.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));