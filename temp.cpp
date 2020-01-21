#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef vector<int> vi;
typedef vector<ll> vll;
typedef pair<int, int> ii;
typedef vector<ii> vii;

#define pb push_back
#define mp make_pair
#define fi first
#define se second
#define rep(i, a, b) \
for (int i = int(a); i < int(b); i++) // a to b, and variable i is local!
#define TRvi(c, it) \
for (vi::iterator it = (c).begin(); it != (c).end(); it++)
#define mod 1000000007

int factorial[100025];

void init(){
	factorial[0] = 1;
	for(int i = 1; i < 100025; i++){
		factorial[i] = ((ll)factorial[i-1] * i)%mod;
	}
}

ll power(ll a, ll b){
	ll res = 1;
	a = a % mod;
	while(b > 0){
		if(b & 1){
			res = (res * a)%mod;
		}

		b = b >> 1;
		a = (a * a)%mod;
	}
	return res;
}

ll modInverse(int n){
	return power(n,mod-2);
}

//not sure about this function
ll C(int n,int r){
	if(n <= 0 || r == 0){
		return 1;
	}
	//cout<<factorial[n]<<" "<<modInverse(factorial[r])<<" "<<modInverse(factorial[n-r])<<endl;
	ll ans = (factorial[n] * modInverse(factorial[r])%mod * modInverse(factorial[n-r])%mod)%mod;
	
	return ans;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);cout.tie(NULL);
	init();
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		vi x(2*n);
		ll ans = 0;

		unordered_map<int,int> elementFreq;
		// possible candidate for last element
		vi lastElement;
		lastElement.reserve(n);
		rep(i,0,2*n){
			cin>>x[i];
			elementFreq[x[i]]++;
			if(elementFreq[x[i]] == 2){
				lastElement.pb(x[i]);
			}
		}
		//check if its valid arr given last element
		//compute uniqueArrFreq = {element, freq} doest not contain counter elements
		//update ans
		rep(i,0,lastElement.size()){
			bool isOk = true;
			elementFreq[lastElement[i]] -= 2;
			unordered_set<int> skip;
			vii uniqueArrFreq;
			uniqueArrFreq.reserve(n-1);

			rep(j,0,2*n){
				if(skip.find(x[j]) != skip.end()){
					continue;
				}
				if(elementFreq[x[j]] > 0){
					if(elementFreq.find(lastElement[i]-x[j]) == elementFreq.end()){
						isOk = false;
						break;
					}
					else{
						if(elementFreq[x[j]] == elementFreq[lastElement[i]-x[j]]){
							if(x[j] == lastElement[i]-x[j]){
								if(elementFreq[x[j]]%2 == 0){
									skip.insert(x[j]);
									uniqueArrFreq.pb({x[j],elementFreq[x[j]]/2});
								}
								else{
									isOk = false;
									break;
								}
							}
							else{
								skip.insert(x[j]);
								skip.insert(lastElement[i]-x[j]);
								uniqueArrFreq.pb({x[j],elementFreq[x[j]]});
							}
							
						}
						else{
							isOk = false;
							break;
						}
					}
				}
			}
			if(isOk){
				//cout<<"Hmm\n";
				ll temp = 1;
				int size = n-1;

				for(int j = 0; j < (int)uniqueArrFreq.size(); j++){
					ii curr = uniqueArrFreq[j];
					//cout<<"nCr "<<size<<","<<curr.se<<endl;
					temp = (temp * C(size,curr.se))%mod;
					//cout<<"temp = "<<temp<<endl;
					size -= curr.se;
					if(curr.fi != lastElement[i]-curr.fi){
						//cout<<"power 2^"<<curr.se<<endl;
						temp = (temp*power(2,curr.se))%mod;
						//cout<<"temp = "<<temp<<endl;
					}
				}
				ans += temp;
			}
			elementFreq[lastElement[i]] += 2;
		}
		cout<<ans<<'\n';
	}
	return 0;
}