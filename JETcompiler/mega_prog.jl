class ttt
{
	int valx;

	ttt()
	{
		valx = 0;
	}

	void vx(int u)
	{
		valx = valx + 0;
		return;
	}
}


int main()
{
	ttt[] ts = new ttt[5];

	int i;

	for(i = 0 ; i < 5; i = i + 1)
		ts[i] = new ttt();

	for(i = 0 ; i < 5; i = i + 1)
		ts[i].vx(i);

	for(i = 0 ; i < 5; i = i + 1)
		printInt(ts[i].valx);

	return 0;
}


