package base.bill.util;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Str工具.
 */
public class StrKit {

	/**
	 * Constant representing the empty string, equal to &quot;&quot;
	 */
	public static final String EMPTY_STRING = "";

	/**
	 * Constant representing the default delimiter character (comma), equal to
	 * <code>','</code>
	 */
	public static final char DEFAULT_DELIMITER_CHAR = ',';

	/**
	 * Constant representing the default quote character (double quote), equal
	 * to '&quot;'</code>
	 */
	public static final char DEFAULT_QUOTE_CHAR = '"';

	/**
	 * 首字母变小写
	 */
	public static String firstCharToLowerCase(String str) {
		char firstChar = str.charAt(0);
		if (firstChar >= 'A' && firstChar <= 'Z') {
			char[] arr = str.toCharArray();
			arr[0] += ('a' - 'A');
			return new String(arr);
		}
		return str;
	}

	/**
	 * 首字母变大写
	 */
	public static String firstCharToUpperCase(String str) {
		char firstChar = str.charAt(0);
		if (firstChar >= 'a' && firstChar <= 'z') {
			char[] arr = str.toCharArray();
			arr[0] -= ('a' - 'A');
			return new String(arr);
		}
		return str;
	}

	/**
	 * 字符串为 null 或者为 "" 时返回 true
	 */
	public static boolean isBlank(String str) {
		return str == null || EMPTY_STRING.equals(str.trim()) ;
	}
	
	/**
	 * 字符串为 null 或者为 "" 时返回 false
	 */
	public static boolean isBlank(Object  paras) {
		if (paras == null)
			return false;
		if (paras instanceof String)
				return !(paras == null || EMPTY_STRING.equals(paras.toString().trim())) ;
		return true;
	}

	/**
	 * 字符串不为 null 而且不为 "" 时返回 true
	 */
	public static boolean notBlank(String str) {
		return str == null || EMPTY_STRING.equals(str.trim()) ? false : true;
	}

	public static boolean notBlank(String... strings) {
		if (strings == null)
			return false;
		for (String str : strings)
			if (str == null || EMPTY_STRING.equals(str.trim()))
				return false;
		return true;
	}

	public static boolean notNull(Object... paras) {
		if (paras == null)
			return false;
		for (Object obj : paras)
			if (obj == null)
				return false;
		return true;
	}


	public static String[] match(Pattern pattern, String value) {
		String[] result = null;
		Matcher matcher = pattern.matcher(value);
		if (matcher.find()) {
			result = new String[matcher.groupCount()];
			for (int i = 0; i < matcher.groupCount(); i++) {
				result[i] = matcher.group(i + 1);
			}
		}
		return result;
	}

	private static final Pattern formatPattern = Pattern.compile("\\{(\\d)\\}");

	public static String format(String source, Object... args) {
		Matcher matcher = formatPattern.matcher(source);
		while (matcher.find()) {
			source = source.replace(matcher.group(),
					args[Integer.valueOf(matcher.group(1))].toString());
		}
		return source;
	}

	public static String clean(String in) {
		return in != null ? (EMPTY_STRING.equals(in.trim()) ? null : in.trim())
				: null;
	}

	/**
	 * Returns the specified array as a comma-delimited (',') string.
	 *
	 * @param array
	 *            the array whose contents will be converted to a string.
	 * @return the array's contents as a comma-delimited (',') string.
	 * @since 1.0
	 */
	public static String toString(Object[] array) {
		return toDelimitedString(array, ",");
	}

	/**
	 * Returns the array's contents as a string, with each element delimited by
	 * the specified {@code delimiter} argument. Useful for {@code toString()}
	 * implementations and log messages.
	 *
	 * @param array
	 *            the array whose contents will be converted to a string
	 * @param delimiter
	 *            the delimiter to use between each element
	 * @return a single string, delimited by the specified {@code delimiter}.
	 * @since 1.0
	 */
	public static String toDelimitedString(Object[] array, String delimiter) {
		if (array == null || array.length == 0) {
			return EMPTY_STRING;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i > 0) {
				sb.append(delimiter);
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * Returns the collection's contents as a string, with each element
	 * delimited by the specified {@code delimiter} argument. Useful for
	 * {@code toString()} implementations and log messages.
	 *
	 * @param c
	 *            the collection whose contents will be converted to a string
	 * @param delimiter
	 *            the delimiter to use between each element
	 * @return a single string, delimited by the specified {@code delimiter}.
	 * @since 1.2
	 */
	public static String toDelimitedString(Collection<?> c, String delimiter) {
		if (c == null || c.isEmpty()) {
			return EMPTY_STRING;
		}
		return join(c.iterator(), delimiter);
	}

	/**
	 * Tokenize the given String into a String array via a StringTokenizer.
	 * Trims tokens and omits empty tokens.
	 * <p>
	 * The given delimiters string is supposed to consist of any number of
	 * delimiter characters. Each of those characters can be used to separate
	 * tokens. A delimiter is always a single character; for multi-character
	 * delimiters, consider using <code>delimitedListToStringArray</code>
	 * <p/>
	 * <p>
	 * Copied from the Spring Framework while retaining all license, copyright
	 * and author information.
	 *
	 * @param str
	 *            the String to tokenize
	 * @param delimiters
	 *            the delimiter characters, assembled as String (each of those
	 *            characters is individually considered as delimiter).
	 * @return an array of the tokens
	 * @see java.util.StringTokenizer
	 * @see java.lang.String#trim()
	 */
	public static String[] tokenizeToStringArray(String str, String delimiters) {
		return tokenizeToStringArray(str, delimiters, true, true);
	}

	/**
	 * Tokenize the given String into a String array via a StringTokenizer.
	 * <p>
	 * The given delimiters string is supposed to consist of any number of
	 * delimiter characters. Each of those characters can be used to separate
	 * tokens. A delimiter is always a single character; for multi-character
	 * delimiters, consider using <code>delimitedListToStringArray</code>
	 * <p/>
	 * <p>
	 * Copied from the Spring Framework while retaining all license, copyright
	 * and author information.
	 *
	 * @param str
	 *            the String to tokenize
	 * @param delimiters
	 *            the delimiter characters, assembled as String (each of those
	 *            characters is individually considered as delimiter)
	 * @param trimTokens
	 *            trim the tokens via String's <code>trim</code>
	 * @param ignoreEmptyTokens
	 *            omit empty tokens from the result array (only applies to
	 *            tokens that are empty after trimming; StringTokenizer will not
	 *            consider subsequent delimiters as token in the first place).
	 * @return an array of the tokens (<code>null</code> if the input String was
	 *         <code>null</code>)
	 * @see java.util.StringTokenizer
	 * @see java.lang.String#trim()
	 */
	public static String[] tokenizeToStringArray(String str, String delimiters,
			boolean trimTokens, boolean ignoreEmptyTokens) {

		if (str == null) {
			return null;
		}
		StringTokenizer st = new StringTokenizer(str, delimiters);
		List<Object> tokens = new ArrayList<Object>();
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (trimTokens) {
				token = token.trim();
			}
			if (!ignoreEmptyTokens || token.length() > 0) {
				tokens.add(token);
			}
		}
		return toStringArray(tokens);
	}

	/**
	 * Copy the given Collection into a String array. The Collection must
	 * contain String elements only.
	 * <p/>
	 * <p>
	 * Copied from the Spring Framework while retaining all license, copyright
	 * and author information.
	 *
	 * @param collection
	 *            the Collection to copy
	 * @return the String array (<code>null</code> if the passed-in Collection
	 *         was <code>null</code>)
	 */
	public static String[] toStringArray(Collection<?> collection) {
		if (collection == null) {
			return null;
		}
		return (String[]) collection.toArray(new String[collection.size()]);
	}

	public static String[] splitKeyValue(String aLine) throws ParseException {
		String line = clean(aLine);
		if (line == null) {
			return null;
		}
		String[] split = line.split(" ", 2);
		if (split.length != 2) {
			split = line.split("=", 2);
			if (split.length != 2) {
				String msg = "Unable to determine Key/Value pair from line ["
						+ line + "].  There is no space from "
						+ "which the split location could be determined.";
				throw new ParseException(msg, 0);
			}

		}

		split[0] = clean(split[0]);
		split[1] = clean(split[1]);
		if (split[1].startsWith("=")) {
			// they used spaces followed by an equals followed by zero or more
			// spaces to split the key/value pair, so
			// remove the equals sign to result in only the key and values in
			// the
			split[1] = clean(split[1].substring(1));
		}

		if (split[0] == null) {
			String msg = "No valid key could be found in line [" + line
					+ "] to form a key/value pair.";
			throw new ParseException(msg, 0);
		}
		if (split[1] == null) {
			String msg = "No corresponding value could be found in line ["
					+ line + "] for key [" + split[0] + "]";
			throw new ParseException(msg, 0);
		}

		return split;
	}

	public static String[] split(String line) {
		return split(line, DEFAULT_DELIMITER_CHAR);
	}

	public static String[] split(String line, char delimiter) {
		return split(line, delimiter, DEFAULT_QUOTE_CHAR);
	}

	public static String[] split(String line, char delimiter, char quoteChar) {
		return split(line, delimiter, quoteChar, quoteChar);
	}

	public static String[] split(String line, char delimiter,
			char beginQuoteChar, char endQuoteChar) {
		return split(line, delimiter, beginQuoteChar, endQuoteChar, false, true);
	}

	/**
	 * Splits the specified delimited String into tokens, supporting quoted
	 * tokens so that quoted strings themselves won't be tokenized.
	 * <p/>
	 * This method's implementation is very loosely based (with significant
	 * modifications) on <a href="http://blogs.bytecode.com.au/glen">Glen
	 * Smith</a>'s open-source <a href=
	 * "http://opencsv.svn.sourceforge.net/viewvc/opencsv/trunk/src/au/com/bytecode/opencsv/CSVReader.java?&view=markup"
	 * >CSVReader.java</a> file.
	 * <p/>
	 * That file is Apache 2.0 licensed as well, making Glen's code a great
	 * starting point for us to modify to our needs.
	 *
	 * @param aLine
	 *            the String to parse
	 * @param delimiter
	 *            the delimiter by which the <tt>line</tt> argument is to be
	 *            split
	 * @param beginQuoteChar
	 *            the character signifying the start of quoted text (so the
	 *            quoted text will not be split)
	 * @param endQuoteChar
	 *            the character signifying the end of quoted text
	 * @param retainQuotes
	 *            if the quotes themselves should be retained when constructing
	 *            the corresponding token
	 * @param trimTokens
	 *            if leading and trailing whitespace should be trimmed from
	 *            discovered tokens.
	 * @return the tokens discovered from parsing the given delimited
	 *         <tt>line</tt>.
	 */
	public static String[] split(String aLine, char delimiter,
			char beginQuoteChar, char endQuoteChar, boolean retainQuotes,
			boolean trimTokens) {
		String line = clean(aLine);
		if (line == null) {
			return null;
		}

		List<String> tokens = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		boolean inQuotes = false;

		for (int i = 0; i < line.length(); i++) {

			char c = line.charAt(i);
			if (c == beginQuoteChar) {
				// this gets complex... the quote may end a quoted block, or
				// escape another quote.
				// do a 1-char lookahead:
				if (inQuotes // we are in quotes, therefore there can be escaped
								// quotes in here.
						&& line.length() > (i + 1) // there is indeed another
													// character to check.
						&& line.charAt(i + 1) == beginQuoteChar) { // ..and that
																	// char. is
																	// a quote
																	// also.
					// we have two quote chars in a row == one quote char, so
					// consume them both and
					// put one on the token. we do *not* exit the quoted text.
					sb.append(line.charAt(i + 1));
					i++;
				} else {
					inQuotes = !inQuotes;
					if (retainQuotes) {
						sb.append(c);
					}
				}
			} else if (c == endQuoteChar) {
				inQuotes = !inQuotes;
				if (retainQuotes) {
					sb.append(c);
				}
			} else if (c == delimiter && !inQuotes) {
				String s = sb.toString();
				if (trimTokens) {
					s = s.trim();
				}
				tokens.add(s);
				sb = new StringBuilder(); // start work on next token
			} else {
				sb.append(c);
			}
		}
		String s = sb.toString();
		if (trimTokens) {
			s = s.trim();
		}
		tokens.add(s);
		return tokens.toArray(new String[tokens.size()]);
	}

	/**
	 * Joins the elements of the provided {@code Iterator} into a single String
	 * containing the provided elements.</p>
	 * <p/>
	 * No delimiter is added before or after the list. A {@code null} separator
	 * is the same as an empty String ("").
	 * </p>
	 * <p/>
	 * Copied from Commons Lang, version 3 (r1138702).
	 * </p>
	 *
	 * @param iterator
	 *            the {@code Iterator} of values to join together, may be null
	 * @param separator
	 *            the separator character to use, null treated as ""
	 * @return the joined String, {@code null} if null iterator input
	 * @since 1.2
	 */
	public static String join(Iterator<?> iterator, String separator) {
		final String empty = "";

		// handle null, zero and one elements before building a buffer
		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return empty;
		}
		Object first = iterator.next();
		if (!iterator.hasNext()) {
			return first == null ? empty : first.toString();
		}

		// two or more elements
		StringBuilder buf = new StringBuilder(256); // Java default is 16,
													// probably too small
		if (first != null) {
			buf.append(first);
		}

		while (iterator.hasNext()) {
			if (separator != null) {
				buf.append(separator);
			}
			Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}
		return buf.toString();
	}


	/**
	 * Returns the input argument, but ensures the first character is
	 * capitalized (if possible).
	 * 
	 * @param in
	 *            the string to uppercase the first character.
	 * @return the input argument, but with the first character capitalized (if
	 *         possible).
	 * @since 1.2
	 */
	public static String uppercaseFirstChar(String in) {
		if (in == null || in.length() == 0) {
			return in;
		}
		int length = in.length();
		StringBuilder builder = new StringBuilder(length);

		builder.append(Character.toUpperCase(in.charAt(0)));
		if (length > 1) {
			String remaining = in.substring(1);
			builder.append(remaining);
		}
		return builder.toString();
	}

	public static boolean checkNum(String value) {
		if (notBlank(value))
			return value.matches("\\d+");
		else
			return false;
	}
	
    /**
     * 对传入BigDecimal类型进行四舍五入操作 
     * @param big BigDecimal 从命令行输入的那个数 
     * @return 四舍五入后的新值 
     */
     public static BigDecimal getRMBBigDecimal(BigDecimal big){
    	 java.text.DecimalFormat df=new java.text.DecimalFormat("0.00");
    	 return new BigDecimal(df.format(big));
     }
     
     public static String  getRMBStr(BigDecimal big,String format){
    	    NumberFormat nf = new DecimalFormat(format);
    	    return big.intValue() == 0?"0.0":nf.format(big);
    }
    /* public static void main(String[] args)
	{
    	 String aa = getRMBStr(new BigDecimal("3333333.03"));
		System.err.println(aa.toString());
	}*/
     
     public static String  getRMBStr(BigDecimal big){
 	    return getRMBStr(big,"#,###.00");
 	}
}
