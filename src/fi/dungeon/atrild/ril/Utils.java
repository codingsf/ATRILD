package fi.dungeon.atrild.ril;

public class Utils {

    public static String bytesToHexString(byte[] bytes) {
    	return bytesToHexString(bytes, 0, bytes.length);
	}

    public static String bytesToHexString(byte[] bytes, int i, int length) {
		if (bytes == null)
			return null;
		StringBuilder ret = new StringBuilder(2 * length);
		for (; i < length; i++) {
			int b;
			b = 0x0f & (bytes[i] >> 4);
			ret.append("0123456789abcdef".charAt(b));
			b = 0x0f & bytes[i];
			ret.append("0123456789abcdef".charAt(b));
		}
		return ret.toString();
	}

    static int
    hexCharToInt(char c) {
        if (c >= '0' && c <= '9') return (c - '0');
        if (c >= 'A' && c <= 'F') return (c - 'A' + 10);
        if (c >= 'a' && c <= 'f') return (c - 'a' + 10);

        throw new RuntimeException ("invalid hex char '" + c + "'");
    }

    public static byte[]
    hexStringToBytes(String s) {
        byte[] ret;

        if (s == null) return null;

        int sz = s.length();

        ret = new byte[sz/2];

        for (int i=0 ; i <sz ; i+=2) {
            ret[i/2] = (byte) ((hexCharToInt(s.charAt(i)) << 4)
                                | hexCharToInt(s.charAt(i+1)));
        }

        return ret;
    }
}
