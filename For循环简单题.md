### For循环简单题

1. 计算0-100之间的奇数和偶数的和

   ```java
   int sumDouble = 0;
   int sumSingle = 0;
   for(int i = 1; i < 101; i ++){
     if(i % 2 == 0){//i 为偶数
       sumDouble = sumDouble + i;
     }else {
       sumSingle = sumSingle + i;
     }
   }
   System.out.println("奇数的和为： " + sumSingle + "\t偶数的和为： " + sumDouble);

   ```

2. 用while或for循环输出1-1000之间能被5整除的数，并且每行输出3个

   ```java
   int count = 0;
   for(int i = 0; i < 1000; i ++){
     if(i % 5 == 0){
       System.out.print(i + "\t");
       count ++;
       if(count % 3 == 0){
         System.out.println();
       }
     }
   }

   ```

3. 打印九九乘法表

   ```java
   for(int i = 1; i <= 9; i ++){
     for(int j = 1; j <= i; j ++){
       System.out.print(j + "*" + i + "\t");
       if(i == j){
         System.out.println();
       }
     }
   }
   ```

   ​