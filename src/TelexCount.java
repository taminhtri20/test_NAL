import java.util.HashMap;
import java.util.Map;

public class TelexCount {
    // Định nghĩa các mẫu Telex và các chữ cái tương ứng
    private static final Map<String, String> telexMap = new HashMap<>();

    static {
        telexMap.put("aw", "ă");
        telexMap.put("aa", "â");
        telexMap.put("dd", "đ");
        telexMap.put("ee", "ê");
        telexMap.put("oo", "ô");
        telexMap.put("ow", "ơ");
        telexMap.put("w", "ư");
    }

    // Hàm đếm số lượng các chữ cái có dấu trong chuỗi nhập vào
    public static int countVietnameseAccents(String input) {
        int count = 0;

        // Duyệt qua chuỗi và tìm các cặp ký tự hoặc ký tự đơn thuộc bảng Telex
        for (int i = 0; i < input.length(); i++) {
            // Kiểm tra trường hợp cặp 2 ký tự
            if (i < input.length() - 1) {
                String twoChar = input.substring(i, i + 2);
                if (telexMap.containsKey(twoChar)) {
                    count++;
                    i++; // Nhảy qua cặp ký tự này để tránh lặp lại
                    continue;
                }
            }

            // Kiểm tra trường hợp ký tự đơn lẻ
            String oneChar = input.substring(i, i + 1);
            if (telexMap.containsKey(oneChar)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String input = "hwfdawhwhcoomddfgwdc";
        int result = countVietnameseAccents(input);
        System.out.println("Số lượng chữ cái có dấu: " + result);
    }
}
