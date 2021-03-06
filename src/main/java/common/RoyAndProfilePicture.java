package common;

import java.util.Scanner;

/**
 * Roy wants to change his profile picture on Facebook. Now Facebook has some restriction over the dimension of picture that we can upload.
 * Minimum dimension of the picture can be L x L, where L is the length of the side of square.
 * <p>
 * Now Roy has N photos of various dimensions.
 * Dimension of a photo is denoted as W x H
 * where W - width of the photo and H - Height of the photo
 * <p>
 * When any photo is uploaded following events may occur:
 * <p>
 * [1] If any of the width or height is less than L, user is prompted to upload another one. Print "UPLOAD ANOTHER" in this case.
 * [2] If width and height, both are large enough and
 * (a) if the photo is already square then it is accepted. Print "ACCEPTED" in this case.
 * (b) else user is prompted to crop it. Print "CROP IT" in this case.
 */
public class RoyAndProfilePicture {
    public static void main(String[] a) {
        Scanner scanner = new Scanner(System.in);
        int L, N, W, H;
        L = scanner.nextInt();
        N = scanner.nextInt();
        for(int i = 0; i < N; i++){
            W = scanner.nextInt();
            H = scanner.nextInt();
            if(W < L || H < L){
                System.out.println("UPLOAD ANOTHER");
            } else if (W == H){
                System.out.println("ACCEPTED");
            } else{
                System.out.println("CROP IT");
            }

        }
    }
}
