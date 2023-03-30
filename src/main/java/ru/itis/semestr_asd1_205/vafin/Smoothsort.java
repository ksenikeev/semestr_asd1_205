package ru.itis.semestr_asd1_205.vafin;

public class Smoothsort {
    int count = 0;

    private static int leonardo(int n) {
        int[] leonardoNumbers = new int[]{1, 1, 3, 5, 9, 15, 25, 41, 67, 109,
                177, 287, 465, 753, 1219, 1973, 3193, 5167, 8361, 13529, 21891,
                35421, 57313, 92735, 150049, 242785, 392835, 635621, 1028457,
                1664079, 2692537, 4356617, 7049155, 11405773, 18454929, 29860703,
                48315633, 78176337, 126491971, 204668309, 331160281, 535828591,
                866988873};
        return leonardoNumbers[n];
    }

    private void sift(int[] arr, int head, int exp) {
        int temp = arr[head];

        while (exp > 1) {
            int right = head - 1;
            int left = head - 1 - leonardo(exp - 2);
            if (temp-(arr[left]) >= 0 && temp-(arr[right]) >= 0) {
                count++;
                break;
            }
            if (arr[left]-(arr[right]) >= 0) {
                arr[head] = arr[left];
                head = left;
                exp -= 1;
                count++;
            } else {
                arr[head] = arr[right];
                head = right;
                exp -= 2;
                count++;
            }
        }
        arr[head] = temp;
    }

    private void arrange(int[] arr, int head, long frac, int exp) {
        int temp = arr[head];
        while (frac > 1) {
            int next = head - leonardo(exp);
            if (temp-(arr[next]) >= 0) {
                count++;
                break;
            }
            if (exp > 1) {
                int right = head - 1;
                int left = head - 1 - leonardo(exp - 2);
                if (arr[left]-(arr[next]) >= 0 || arr[right]-(arr[next]) >= 0) {
                    count++;
                    break;
                }
            }
            arr[head] = arr[next];
            head = next;
            int trail = Long.numberOfTrailingZeros(frac - 1);
            frac >>>= trail;
            exp += trail;
        }
        arr[head] = temp;
        sift(arr, head, exp);
    }

    public void sort(int[] arr) {
        if (arr.length == 0) { count++;
            return;
        }
        int head = 0;
        long frac = 0;
        int exp = 0;

        while (head < arr.length) {
            if ((frac & 3) == 3) {
                frac >>>= 2;
                exp += 2;
                count++;
            } else if (exp > 1) {
                frac <<= exp - 1;
                exp = 1;
                count++;
            } else {
                frac <<= exp;
                exp ^= 1;
                count++;
            }
            frac++;
            if (exp > 0 && arr.length - head - 1 <
                    leonardo(exp - 1) + 1) {
                arrange(arr, head, frac, exp);
            }
            sift(arr, head, exp);
            head++;
            count++;
        }
        arrange(arr, head - 1, frac, exp);
        while (head > 0) {
            head--;
            if (exp > 1) {
                count++;
                frac <<= 2;
                frac--;
                exp -= 2;
                arrange(arr, head - leonardo(exp) - 1, frac >> 1, exp + 1);
                arrange(arr, head - 1, frac, exp);
            } else {
                count++;
                int trail = Long.numberOfTrailingZeros(frac - 1);
                frac >>= trail;
                exp += trail;
            }
        }
    }

    public int getCount() {
        return count;
    }
}