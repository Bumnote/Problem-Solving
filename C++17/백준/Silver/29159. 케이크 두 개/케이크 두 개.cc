#include <iostream>
using namespace std;

typedef long long ll;

ll gcd(ll a, ll b)
{
	if (b == 0) return a;
	else return gcd(b, a % b);
}

int main()
{
	ll ax = 0, ay = 0, bx = 0, by =0, x, y, dy, dx, k;
	for (int i = 0; i < 4; i++)
	{
		cin >> x >> y;
		ax += x;
		ay += y;
	}

	for (int i = 0; i < 4; i++)
	{
		cin >> x >> y;
		bx += x;
		by += y;
	}

	dy = by - ay;
	dx = bx - ax;

	ll value = gcd(dx, dy);
	dy /= value;
	dx /= value;

	if (dx < 0)
	{
		dy *= -1;
		dx *= -1;
	}

	cout << dy;
	if (dx != 1) cout << "/" << dx;

	k = dx * by - dy * bx;
	dx *= 4;

	value = gcd(k, dx);
	k /= value;
	dx /= value;

	if (dx < 0)
	{
		k *= -1;
		dx *= -1;
	}

	cout << " " << k;
	if (dx!= 1) cout << "/" << dx;
	return 0;
}