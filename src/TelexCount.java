import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelexCount {
    // Định nghĩa các mẫu Telex và các chữ cái tương ứng
    private static final Map<String, String> telexMap = new HashMap<>();
    private static List<String> foundTelex = new ArrayList<>();
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
        int i = 0;

        // Sử dụng vòng lặp while để duyệt qua chuỗi
        while (i < input.length()) {
            // Kiểm tra trường hợp cặp 2 ký tự
            if (i < input.length() - 1) {
                String twoChar = input.substring(i, i + 2);
                if (telexMap.containsKey(twoChar)) {
                    foundTelex.add(twoChar);
                    count++;
                    i += 2; // Nhảy qua cặp ký tự này để tránh lặp lại
                    continue;
                }
            }

            // Kiểm tra trường hợp ký tự đơn lẻ
            String oneChar = input.substring(i, i + 1);
            if (telexMap.containsKey(oneChar)) {
                foundTelex.add(oneChar);
                count++;
            }

            // Tăng chỉ số để tiếp tục duyệt
            i++;
        }

        return count;
    }

    public static void main(String[] args) {
        String input = "hwfdawhwhcoomddfgwdcoo";
        int result = countVietnameseAccents(input);
        System.out.println("Số lượng chữ cái có dấu: " + result + foundTelex);
    }
}
