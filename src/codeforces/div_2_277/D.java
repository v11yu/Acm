package codeforces.div_2_277;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class D {
	/**
	 * java will Tle, using cpp
	 */
	//============================================================================
	// Name        : codeforces.cpp
	// Author      : 
	// Version     :
	// Copyright   : Your copyright notice
	// Description : Hello World in C++, Ansi-style
	//============================================================================
/*
	#include <iostream>
	#include <cstdio>
	#include <vector>
	#include <map>
	using namespace std;
	#define LL long long

	const int M = 30000+5;
	const int N = 3000+5;
	int ex[M],ey[M];
	map<string,int> mp;
	vector<int> edge[N];
	bool exist(int a,int b){
	    string str = a+"#"+b;
	}
	int mk[N][N];
	int main() {
	    int n,m;
	    scanf("%d %d",&n,&m);
	    for(int i=0;i<m;i++){
	        scanf("%d %d",ex+i,ey+i);
	        edge[ex[i]].push_back(ey[i]);
	    }
	    for(int i=0;i<m;i++){
	        int from = ex[i];
	        int k = ey[i];
	        for(int j=0;j<edge[k].size();j++){
	            int to = edge[k][j];
	            if(from == to) continue;
	            //printf("%d %d\n",from,to);
	            mk[from][to]++;
	        }
	    }
	    LL ans = 0;
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=n;j++){
	            LL t = mk[i][j];
	            //printf("%d %d %d\n",i,j,mk[i][j]);
	            ans += t*(t-1) /2;
	        }
	    }
	    //cout<<ans<<endl;
	    printf("%I64d\n",ans);
	    return 0;
	}
	*/
}
