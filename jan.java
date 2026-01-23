import java.io.*;
class jan
{

	public static void main(String[] args)
	throws IOException
	{
		
//対戦人数入力
		System.out.println("対戦人数を2以上の整数で入力してください。");
		
		BufferedReader br1=
		new BufferedReader
		(new InputStreamReader
			(System.in,"Shift-JIS"));
		
		String str1=br1.readLine();
		int num1=Integer.parseInt(str1);
		
//対戦回数入力
		System.out.println("対戦回数を整数で入力してください。");
		
		BufferedReader br2=
		new BufferedReader
		(new InputStreamReader
			(System.in,"Shift-JIS"));
		
		String str2=br2.readLine();
		int num2=Integer.parseInt(str2);
		
		System.out.println(num1+"人で"+num2+"回戦します。");
		
		//ＯＫ

//配列準備（人数・対戦回数、出し手集計、結果集計）
		String[][] jan=new String[num2][num1];
		int[] count=new int[3];
		int[][] sum=new int[num1+1][6];
		String str5="";
		
		//CPに数字で名前[数字」を付ける。
		for(int p=0;p<num1;p++){
			sum[p][4] =p+1;
		}
		

//出し手決め　（ランダム数字1～3）1グー、2チョキ、3パー o=１回戦目からカウント
	for(int o=0; o<num2; o++){
			
		for(int i=0;i<num1;i++){
			int num =(int)(Math.random()*3)+1;
			if(num==1){
				jan[o][i]="グー";
			}
			else if(num==2){
				jan[o][i]="チョキ";
			}
			else{
				jan[o][i]="パー";
			}
//出し手表示
			System.out.println("COM"+sum[i][4]+"は"+jan[o][i]+"を出しました。");
		}
		
		//OK
		
//出し手集計
		for(int i=0; i<num1;i++){
			if(jan[o][i]=="グー"){
				count[0] +=1;
			}
			else if(jan[o][i]=="チョキ"){
				count[1] +=1;
			}
			else {
				count[2] +=1;
			}
		}
		System.out.println("グーは"+count[0]+"人、チョキは"+count[1]+"人、パーは"+count[2]+"人出しました。");
//ＯＫ
		
		//　0人が２つ以上の場合（あいこ判断準備）
		int aiko=0;
		
		for(int i=0; i<3; i++){
			if(count[i]==0){
				aiko +=1;
			}
		}
//0人が２つ以上は、あいこ　あいこ+1、1pt
		
		if(aiko>=2){
			for(int i=0; i<num1; i++){
				sum[i][2] +=1;
				sum[i][3] +=1;
			}
			System.out.println((o+1)+"回戦結果：あいこです。");
		}
		//ＯＫ
		
//0人がないとき、〃　　　　　〃　　　〃
		else if(aiko==0){
			for(int i=0; i<num1; i++){
				sum[i][2] +=1;
				sum[i][3] +=1;
			}
			System.out.println((o+1)+"回戦結果：あいこです。");
			
		}
	
		
//パーが0人の時、グーの勝ち　勝+1、2pt
		else if(count[2]==0){
			for(int i=0; i<num1; i++){
				if(jan[o][i]=="グー"){
				sum[i][0] +=1;
				sum[i][3] +=2;
				str5 +="COM"+sum[i][4]+" ";
				}
			}
			System.out.println((o+1)+"回戦結果：グーの人("+str5+")の勝ちです。");
		str5="";
			}
		//ＯＫ
	
//グーが0人の時、チョキの勝ち　勝+1、2pt
			else if(count[0]==0){
			for(int i=0; i<num1; i++){
				if(jan[o][i]=="チョキ"){
				sum[i][0] +=1;
				sum[i][3] +=2;
				str5 +="COM"+sum[i][4]+" ";
				}
			}
			System.out.println((o+1)+"回戦結果：チョキの人("+str5+")の勝ちです。");
		str5="";
			}
//チョキが0人の時、パーの勝ち　勝+1、2pt
			else if(count[1]==0){
			for(int i=0; i<num1; i++){
				if(jan[o][i]=="パー"){
				sum[i][0] +=1;
				sum[i][3] +=2;
				str5 +="COM"+sum[i][4]+" ";
				}
			}
			System.out.println((o+1)+"回戦結果：パーの人("+str5+")の勝ちです。");
		str5="";
			
			}
		
//対戦が終わったらエンターキーで次の試合へ。対戦がすべて終了したら結果発表		
		if(o+1==num2){
		System.out.println((o+1)+"回戦が終わりました。いよいよ結果発表です！");
		}
		else{
			System.out.println((o+1)+"回戦が終わりました。Enterキーを押してください。次の対戦をはじめます。");
		}
		
		BufferedReader br3=
		new BufferedReader
		(new InputStreamReader
			(System.in,"Shift-JIS"));
		
		String str3=br3.readLine();
//ＯＫ
		count[0]=0;
		count[1]=0;
		count[2]=0;
		aiko=0;
		
	}		
		
		
//結果集計、ポイントが高い順で並べ替え
		int num3=num1++;
		for(int i=0; i<num1-1; i++){
			for(int j=i+1; j<num1; j++){
				if(sum[i][3]<sum[j][3]){
					sum[num3]=sum[i];
					sum[i]=sum[j];
					sum[j]=sum[num3];
				}
			}
		}
		

//結果発表
		
		
		//ＯＫ
		
		//順位を入れていく。
		for(int i=0; i<num1; i++){
			if(i==0){
				sum[0][5]=1;
			}
			else if(sum[i][3]==sum[i-1][3]){
				sum[i][5]=sum[i-1][5];

			}
			else{
				sum[i][5]=i+1;
			}
		}
		for(int i=0; i<num1-1;i++){
		System.out.println(sum[i][5]+"位はCOM"+sum[i][4]+"です！"+sum[i][0]+"勝"+sum[i][2]+"あいこ"+sum[i][3]+"ポイントです。");
		}
//ＯＫ		
		
		
		
//参加するかどうか？		
		System.out.println("あなたも参加しますか？yまたはnを入力してください。");
		BufferedReader br17=
		new BufferedReader
		(new InputStreamReader
			(System.in,"Shift-JIS"));
		
		String str17=br17.readLine();
		char res=str17.charAt(0);
		
		if(res == 'Y'|| res =='y'){
			System.out.println("参加ですね！");

		
		
//対戦人数入力
		System.out.println("対戦人数を2以上の整数で入力してください。");
		
		BufferedReader br11=
		new BufferedReader
		(new InputStreamReader
			(System.in,"Shift-JIS"));
		
		String str11=br11.readLine();
		int num11=Integer.parseInt(str11);
		
//対戦回数入力
		System.out.println("対戦回数を整数で入力してください。");
		
		BufferedReader br12=
		new BufferedReader
		(new InputStreamReader
			(System.in,"Shift-JIS"));
		
		String str12=br12.readLine();
		int num12=Integer.parseInt(str12);
		
		System.out.println(num11+"人で"+num12+"回戦します。");
		
		//ＯＫ
		
//配列準備（人数・対戦回数、出し手集計、結果集計）
		String[][] jan10=new String[num12][num11];
		int[] count10=new int[3];
		int[][] sum10=new int[num11+1][6];
		String str15="";
		
		//CPに数字で名前[数字」を付ける。
		for(int p=0;p<num11;p++){
			sum10[p][4] =p+1;
		}
		

//出し手決め　（ランダム数字1～3）1グー、2チョキ、3パー o=１回戦目からカウント
	for(int o=0; o<num12; o++){
			
			System.out.println("1（グー)または2(チョキ)または3(パー)を入力してください。");
			BufferedReader br21=
				new BufferedReader
				(new InputStreamReader
				(System.in,"Shift-JIS"));
		
			String str21=br21.readLine();
			int num21=Integer.parseInt(str21);
		
		if(num21==1){
				jan10[o][num11-1]="グー";
			}
			else if(num21==2){
				jan10[o][num11-1]="チョキ";
			}
			else{
				jan10[o][num11-1]="パー";
			}

		System.out.println("あなたは"+jan10[o][num11-1]+"を出しました。");
		
		
//手を変数に入れる		
		
		
		for(int i=0;i<num11-1;i++){
			int num01 =(int)(Math.random()*3)+1;
			if(num01==1){
				jan10[o][i]="グー";
			}
			else if(num01==2){
				jan10[o][i]="チョキ";
			}
			else{
				jan10[o][i]="パー";
			}
			
			
//出し手表示
			System.out.println("COM"+sum10[i][4]+"は"+jan10[o][i]+"を出しました。");
		}
		
		
		//OK
		
//出し手集計
		for(int i=0; i<num11;i++){
			if(jan10[o][i]=="グー"){
				count10[0] +=1;
			}
			else if(jan10[o][i]=="チョキ"){
				count10[1] +=1;
			}
			else {
				count10[2] +=1;
			}
		}
		System.out.println("グーは"+count10[0]+"人、チョキは"+count10[1]+"人、パーは"+count10[2]+"人出しました。");
//ＯＫ
		
		//　0人が２つ以上の場合（あいこ判断準備）
		int aiko10=0;
		
		for(int i=0; i<3; i++){
			if(count10[i]==0){
				aiko10 +=1;
			}
		}
//0人が２つ以上は、あいこ　あいこ+1、1pt
		
		if(aiko10>=2){
			for(int i=0; i<num11; i++){
				sum10[i][2] +=1;
				sum10[i][3] +=1;
			}
			System.out.println((o+1)+"回戦結果：あいこです。");
		}
		//ＯＫ
		
//0人がないとき、〃　　　　　〃　　　〃
		else if(aiko10==0){
			for(int i=0; i<num11; i++){
				sum10[i][2] +=1;
				sum10[i][3] +=1;
			}
			System.out.println((o+1)+"回戦結果：あいこです。");
			
		}
	
		
//パーが0人の時、グーの勝ち　勝+1、2pt
		else if(count10[2]==0){
			for(int i=0; i<num11; i++){
			if(i==num11-1){
				if(jan10[o][num11-1]=="グー"){
				str15+="あなた";
				sum10[i][0] +=1;
				sum10[i][3] +=2;
				}
			}
			else if(jan10[o][i]=="グー"){
				sum10[i][0] +=1;
				sum10[i][3] +=2;
				str15 +="COM"+sum10[i][4]+" ";
				}
			}
			System.out.println((o+1)+"回戦結果：グーの人("+str15+")の勝ちです。");
		str15="";
			}
		//ＯＫ
	
//グーが0人の時、チョキの勝ち　勝+1、2pt
			else if(count10[0]==0){
			for(int i=0; i<num11; i++){
			if(i==num11-1){
				if(jan10[o][num11-1]=="チョキ"){
				str15+="あなた";
				sum10[i][0] +=1;
				sum10[i][3] +=2;
				}
			}
			else if(jan10[o][i]=="チョキ"){
				sum10[i][0] +=1;
				sum10[i][3] +=2;
				str15 +="COM"+sum10[i][4]+" ";
				}
			}
			System.out.println((o+1)+"回戦結果：チョキの人("+str15+")の勝ちです。");
		str15="";
			}
//チョキが0人の時、パーの勝ち　勝+1、2pt
			else if(count10[1]==0){
			for(int i=0; i<num11; i++){
			if(i==num11-1){
				if(jan10[o][num11-1]=="パー"){
				str15+="あなた";
				sum10[i][0] +=1;
				sum10[i][3] +=2;
				}
			}
				else if(jan10[o][i]=="パー"){
				sum10[i][0] +=1;
				sum10[i][3] +=2;
				str15 +="COM"+sum10[i][4]+" ";
				}
			}
			System.out.println((o+1)+"回戦結果：パーの人("+str15+")の勝ちです。");
		str15="";
			
			}
		
//対戦が終わったらエンターキーで次の試合へ。対戦がすべて終了したら結果発表		
		if(o+1==num12){
		System.out.println((o+1)+"回戦が終わりました。いよいよ結果発表です！");
		}
		else{
			System.out.println((o+1)+"回戦が終わりました。Enterキーを押してください。次の対戦をはじめます。");
		}
		
		BufferedReader br13=
		new BufferedReader
		(new InputStreamReader
			(System.in,"Shift-JIS"));
		
		String str13=br13.readLine();
//ＯＫ
		count10[0]=0;
		count10[1]=0;
		count10[2]=0;
		aiko10=0;
		
	}		
		
		
//結果集計、ポイントが高い順で並べ替え
		int num13=num11++;
		for(int i=0; i<num11-1; i++){
			for(int j=i+1; j<num11; j++){
				if(sum10[i][3]<sum10[j][3]){
					sum10[num13]=sum10[i];
					sum10[i]=sum10[j];
					sum10[j]=sum10[num13];
				}
			}
		}
		

//結果発表
		
		
		//ＯＫ
		
		//順位を入れていく。
		for(int i=0; i<num11; i++){
			if(i==0){
				sum10[0][5]=1;
			}
			else if(sum10[i][3]==sum10[i-1][3]){
				sum10[i][5]=sum10[i-1][5];

			}
			else{
				sum10[i][5]=i+1;
			}
		}
		for(int i=0; i<num11-1;i++){
			String str21="";
			if(sum10[i][4]==num11-1){
				str21="あなた";
			}
			else{
				str21="COM"+sum10[i][4];
			}
		System.out.println(sum10[i][5]+"位は"+str21+"です！"+sum10[i][0]+"勝"+sum10[i][2]+"あいこ"+sum10[i][3]+"ポイントです。");
		}
//ＯＫ
		}
		else if(res == 'N'|| res =='n'){
		}
		else{
			System.out.println("yまたはnを入力してください。");
		}
		
		System.out.println("ありがとうございました！また使ってね！");
	}
}
