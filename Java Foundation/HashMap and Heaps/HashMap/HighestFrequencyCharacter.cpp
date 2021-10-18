#include <bits/stdc++.h>
using namespace std;
int main()
{
    unordered_map<char, int> map;
    string s;
    cin >> s;
    for (int i = 0; i < s.length(); i++)
    {
        map[s[i]]++;
    }
    int maxFreq = INT_MIN;
    char ch;
    for (int i = 0; i < s.length(); i++)
    {
        if (map[s[i]] > maxFreq)
        {
            ch = s[i];
            maxFreq = map[s[i]];
        }
    }
    cout << ch;
}