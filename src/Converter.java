import java.util.Arrays;

public class Converter {

    public String toBinary(int decimal) {
        // To convert decimal to binary, we divide and get the remainder
        // We continuously do this

        StringBuilder finalBinary = new StringBuilder();

        while (decimal > 0) {
            finalBinary.append(decimal % 2);
            decimal = decimal / 2;
        }

        return finalBinary.reverse().toString();
    }

    public String[] toBinary(double decimal){
        // This function we will have to do the binary twice
        String binaryString = String.valueOf(decimal);
        String[] binaries = binaryString.split("\\.");

        String binaryLeft = binaries[0];
        int binaryL = Integer.parseInt(binaryLeft);
        String binaryRight = "0." + binaries[1];
        double binaryR = Double.parseDouble(binaryRight);

        StringBuilder finalBinary = new StringBuilder();

        // First section of the binary done
        while (binaryL > 0) {
            finalBinary.append(binaryL % 2);
            binaryL = binaryL / 2;
        }

        finalBinary.reverse();
        // Decimal to the next section
        finalBinary.append(".");
        int counter = 0;

        while (counter < 5 && !(binaryR == 0)) {
            binaryR = binaryR * 2;
            String[] temp = String.valueOf(binaryR).split("");

            if(Integer.parseInt(temp[0]) >= 1){
                finalBinary.append(temp[0]);
                binaryR -= 1;
            }else{
                finalBinary.append(0);
            }
            counter++;
        }

        String remark = "";
        if(counter == 5){
            remark = "Approximate";
        }else{
            remark = "Exact";
        }

        return new String[]{finalBinary.toString(), remark};
    }

    public int toDecimal(String binary){
        // For every item in the string, if a positive bit,
        // do 2 to the power of the index

        int finalDecimal = 0;
        StringBuilder binaryString = new StringBuilder(binary);
        StringBuilder binaryReversed = binaryString.reverse();

        for(int i = 0; i < binaryReversed.length(); i++){
            boolean positiveBit = binaryReversed.charAt(i) == '1';
            if(positiveBit){
                finalDecimal += Math.pow(2, i);
            }
        }
        return finalDecimal;
    }

    public String toHex(int decimal){
        // char array to store hexadecimal number
        StringBuilder hex = new StringBuilder(decimal);

        while (decimal != 0) {
            int temp = decimal % 16;

            if (temp < 10) {
                hex.append((char)(temp + 48));
            }
            else {
                hex.append((char)(temp + 55));
            }

            decimal = decimal / 16;
        }

        return hex.reverse().toString();
    }
}
