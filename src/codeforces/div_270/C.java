package codeforces.div_270;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    static Name name[];
    static Person p[];
    static int num[];
    static int MAX = 1000000;
    static int t[] = new int[MAX];
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer  = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        name = new Name[2*n];
        p = new Person[n];
        num = new int[n];
        for(int i=0;i<n;i++){
            tokenizer  = new StringTokenizer(reader.readLine());
            name[2*i] = new Name();
            name[2*i+1] = new Name();
            p[i] = new Person();
            name[2*i].s = tokenizer.nextToken();
            name[2*i+1].s = tokenizer.nextToken();
            name[2*i].who = i;
            name[2*i+1].who = i;
        }
        tokenizer  = new StringTokenizer(reader.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(name);
        for(int i=0;i<name.length;i++){
            int d = name[i].who;
            if(p[d].a == null) p[d].a = i+1;
            else p[d].b = i+1;
        }
        int maxNum = 0;
        for(int ii=0;ii<n;ii++){
            boolean ok = false;
            int i = num[ii]-1;
            if(maxNum<p[i].a && get(p[i].a)== ii){
                add(p[i].a,1);
                ok = true;
                maxNum = p[i].a;
            }
            else if (maxNum<p[i].b && get(p[i].b)== ii){
                add(p[i].b,1);
                ok = true;
                maxNum = p[i].b;
            }
            if(!ok){
                System.out.println("NO");
                return ;
            }
        }
        System.out.println("YES");
    }
    private static void add(int x,int v){
        for(int i=x;i<MAX;i+=(i&(-i))){
            t[i] += v;
        }
    }
    private static int get(int x){
        int ans = 0;
        for(int i=x;i>0;i-=(i&(-i))){
            ans += t[i];
        }
        return ans;
    }
}
class Name implements Comparable<Name>{
    String s;
    int who;
    @Override
    public int compareTo(Name o) {
        // TODO Auto-generated method stub
        return this.s.compareTo(o.s);
    }
}
class Person{
    Integer a,b;
}
