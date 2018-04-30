package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class aaa {
static String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF"};
static final int n = board[0].length();
static final int m = board.length;

public static void main(String[] args) {
char[][] boardTemp = new char[m][n];
char[][] boardTemp2 = new char[m][n];
ArrayList<String> ans = new ArrayList<String>();

//
for (int i = 0; i < m; i++)
for (int j = 0; j < n; j++)
boardTemp[i][j] = board[i].charAt(j);

// 정답 찾기
while (true) {

boolean flag = true;

for (int i = 0; i < m; i++)
for (int j = 0; j < n; j++) 
if (boardTemp[i][j] != boardTemp2[i][j]){
flag = false;
boardTemp2[i][j]=boardTemp[i][j];
}

if(flag){
System.out.println("게임끝");
int score=0;
for(int i = 0 ; i < m ; i++)
for(int j = 0 ; j< n ; j++)
if(boardTemp[i][j]==' ')
score++;
System.out.println("점수:"+score);
break;
}







ans.clear();
for (int i = 0; i < m - 1; i++) {
for (int j = 0; j < n - 1; j++) {
char temp = boardTemp[i][j];

int cnt = 0;
A: while (cnt < 3) {
switch (cnt) {
case 0:
if (boardTemp[i][j + 1] != temp)
break A;

break;
case 1:
if (boardTemp[i + 1][j + 1] != temp)
break A;

break;
case 2:
if (boardTemp[i + 1][j] != temp)
break A;

break;
}
cnt++;
}
if (cnt == 3) {
ans.add(i + "," + j);

}
}
}

// 정답 제거
for (int i = 0; i < ans.size(); i++) {
int y = Integer.parseInt(String.valueOf(ans.get(i).charAt(0)));
int x = Integer.parseInt(String.valueOf(ans.get(i).charAt(2)));
boardTemp[y][x] = ' ';
boardTemp[y][x + 1] = ' ';
boardTemp[y + 1][x] = ' ';
boardTemp[y + 1][x + 1] = ' ';
}



// 빈칸 채우기
for (int i = 1; i < m; i++) {
for (int j = 0; j < n; j++) {
if (boardTemp[i][j] == ' ') {
boardTemp[i][j] = boardTemp[i - 1][j];
boardTemp[i - 1][j] = ' ';
}

}
}
}

}

static void print(char[][] ans) {
for (int i = 0; i < m; i++) {
for (int j = 0; j < n; j++) {
System.out.print(ans[i][j]);
}
System.out.println();

}
}
}