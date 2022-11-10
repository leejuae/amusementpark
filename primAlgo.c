#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define MAX 30

typedef struct LOCATION {
	double x;
	double y;
	char attraction;
}location;

location info[MAX];

int list[MAX][MAX];
int already[MAX], idx[MAX];
double total = 0;

//calculating the shortest way
double cal(int start, int end) {
	double shortest = 0.0;
	shortest = sqrt(pow(info[start].x - info[end].x, 2) + pow(info[start].y - info[end].y, 2));
	return shortest;
}

void prim(int cur, int num, int count) {	//current index, number of input, count
	int next, prev;
	double min = 0, dis;
	already[cur] = 1;
	count++;

	if (count < num) {
		for (int i = 0; i < num; i++) {
			if (already[i] == 1) {
				cur = i;
				for (int j = 0; j < idx[cur]; j++) {
					if (already[list[cur][j]] == 0) {
						if (min == 0) {
							min = cal(cur, list[cur][j]);
							next = list[cur][j];
						}
						else if (cal(cur, list[cur][j]) < min) {
							min = cal(cur, list[cur][j]);
							next = list[cur][j];
							prev = cur;
						}
					}
				}
			}
		}

		total += min;
		prim(next, num, count);
	}
}

int main() {

	FILE* input = fopen("input.txt", "r");
	if (input == NULL) {
		printf("ERROR!! There is no file exist.\n");
		exit(1);
	}

	int num, count = 0;
	fscanf(input, "%d", &num);

	for (int i = 0; i < num; i++)
		fscanf(input, "%lf %lf", &info[i].x, &info[i].y);

	for (int i = 0; i < num; i++)
		for (int j = 0; j < num; j++)
			if (i != j)
				list[i][idx[i] ++] = j;


	prim(0, num, count);
	printf("%.2lf\n", total);
	fclose(input);

	return 0;
}