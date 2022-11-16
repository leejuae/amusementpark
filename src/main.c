#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <limits.h>
#include <stdbool.h>
#include <time.h>

#define MAX 11	//10(���̱ⱸ�� ����) + 1(������ġ)

/*����ü��!*/

//���̱ⱸ�� ��ġ
typedef struct location {
	double x;			//x�� ��ġ
	double y;			//y�� ��ġ
	double waiting;	//�α⵵
	char name[MAX];	//���̱ⱸ �̸�
	int visit;	//�湮���� ���� -> �湮������ ���� 1�� �ٲپ ��湮���� �ʵ��� ��.
}loca;

//route[i]: ��������� i��� ���̱ⱸ���� ��� �ּ� �Ÿ��� �� ���̱ⱸ���� �����ϴµ� ��ġ�� ���̱ⱸ
typedef struct ROUTE {
	double distance;	//�ش� node���� ������ �Ÿ�
	bool possible;		//i��° ���̱ⱸ�� �湮�ߴ��� �湮���� �ʾҴ��� ���������� ����
}route;




/*����������*/
loca attractionInfo[MAX];	//���̱ⱸ���� ��ġ info[0]�� ������ġ�� ���� ����.
route routeInfo[MAX];	//�ּҰŸ��� i��° ���̱ⱸ�� �湮�ϴ� ����� ���̱ⱸ �湮������ �ش� node���� ��� �Ÿ� ����� �� ����
double edge[MAX][MAX];	//edge�� ���� 2���� �迭
int order[MAX];	//�湮�� ���̱ⱸ���� ������� ������.
int cnt = 0;	//0�̸� �Ÿ������� �α⵵�� ó���� �������� �ʱ�ȭ����. 1 �̻��̸� �α⵵�� �������� �ٲ�
				// + ���� ��ġ �������� �湮 ���̱ⱸ ������Ʈ �� ���� ���




/*�Լ���*/
void calEdge();	//��ġ �������� �Ÿ� ����ϴ� �Լ�
int minDistance();	//�ּҰŸ� ����Լ�
void printAttractionRoute();
void dijkstra(int);	//���ͽ�Ʈ�� �˰��� ����






void calEdge() {

	if (cnt == 0) {
		for (int i = 0;i < MAX;i++) {
			attractionInfo[i].x = rand() % 100 + 1; //0-100������ �������� �������� ������ �ϳ� �޾ƿ�.
			attractionInfo[i].y = rand() % 100 + 1; //����
			attractionInfo[i].waiting = rand() % 10 + 20; //���̱ⱸ�� �α⵵
		}

		//�Ÿ����� ������ �ʱ� ������ �ѹ��� �������!! waiting���� ����ġ�� ������ min �� �񱳿� �̿븸 ��.
		for (int i = 0;i < MAX;i++) {
			for (int j = 0;j < MAX;j++) {
				if (i == j) {
					edge[i][j] = 0;	//���� i�� j�� �����ϴٸ�(a���̱ⱸ���� a���̱ⱸ�� ���� ���� 0) 0���� �ʱ�ȭ
				}
				else {
					edge[i][j] = sqrt(pow(attractionInfo[i].x - attractionInfo[j].x, 2) + pow(attractionInfo[i].y - attractionInfo[j].y, 2));	//i������ j������ �Ÿ���� �Լ�
				}
			}
		}
	}

	else if (cnt >= 1) {
		for (int i = 0;i < MAX;i++) {
			if (attractionInfo[i].visit == 0) {	//�湮���� �ʾҴٸ� �α⵵ ��������!
				attractionInfo[i].waiting = rand() % 10 + 20; //���̱ⱸ�� �α⵵
			}
		}
	}

	else {
		printf("calEdge�Լ����� ��������");
	}
}







// shortest path tree�� ���� ���Ե��� ���� ���̱ⱸ�� �� ���� �Ÿ��� ����� ���̱ⱸ�� ã�� �Լ�
int minDistance()
{
	//�񱳸� ���� ���� ���� �� �������
	double min = INT_MAX;
	int min_index = 0;

	//���� �湮���� ���� ����̰�, �Ÿ��� ���� ����� ���̱ⱸ��� min_index���� �� ���̱ⱸ�� ������ �ٲ���.
	for (int v = 0; v < MAX; v++)
		if (routeInfo[v].possible == false && routeInfo[v].distance <= min)
			min = routeInfo[v].distance + attractionInfo[v].waiting, min_index = v;	//!!!!!!!!!!!!!!!!!!!!!!!!!���⿡ waiting ���� �Ǵ°� �³�??????????????????????????????

	//���� ����� ���̱ⱸ�� �� ����
	return min_index;
}





// ����� ��� �Լ�
void printAttractionRoute()
{
	printf("%d-th visit: ", cnt);
	for (int i = cnt; i < MAX; i++) {
		printf("-> %d", order[i]);
	}
	printf("\n\n");
}






void dijkstra(int src)
{
	//ó���� �Ÿ��� �������� �ʱ�ȭ && ���� � ���̱ⱸ���� �湮�� ���� �ʾ����� 0���� �ʱ�ȭ.
	for (int i = 0; i < MAX; i++) {
		routeInfo[i].distance = INT_MAX;
		if (attractionInfo[i].visit == 1)
			routeInfo[i].possible = true;
		else if (attractionInfo[i].visit == 0)
			routeInfo[i].possible = false;
	}

	//��������� ������� ���� �Ÿ��� 0�̹Ƿ� 0���� �ʱ�ȭ
	routeInfo[src].distance = 0.0;

	//���� ª�� �Ÿ� ã��
	for (int count = cnt; count < MAX; count++) {	//���� count�� �������� cnt �ٸ��� �� �����ϱ�!
		//���̱ⱸ ���տ��� ���� ���� �Ÿ��� ã��.
		//ù��° �ݺ����� u�� ������� �ǹ̸� ����
		//-> ��������� ������� ���� �Ÿ��� 0���� �ʱ�ȭ�߱� ������ ù��° �ݺ����� min���� �翬�ϰ� 0��.
		int u = minDistance();

		routeInfo[u].possible = true;	//�湮�����Ƿ� ���� true�� �ٲ���.
		order[count] = u;	//�湮�� ���̱ⱸ���� ����.

		//�湮�� ���̱ⱸ�� �������� �Ÿ����� ��������
		for (int v = 0; v < MAX; v++)
			//���� �湮�� ���ؼ� possible���� false�� ���� ��������! 
			// ���� u���� v���� ���� ���� �����ϰ� 
			// u�� ���ؼ� ��������� v�� ���� ���� routeInfo[v]�� �Ÿ������� ���� ���� ����
			if (!routeInfo[v].possible && edge[u][v]
				&& routeInfo[u].distance != INT_MAX
				&& routeInfo[u].distance + edge[u][v] < routeInfo[v].distance)
				routeInfo[v].distance = routeInfo[u].distance + edge[u][v];
	}
}






int main() {

	srand(time(NULL));	//���α׷� ����ø��� �ٸ��� ������ ����.

	do {
		//1�Է��ϸ� ���α׷� ����
		int num;
		scanf("%d", &num);

		if (num == 1 && cnt < 10) {
			calEdge();
			dijkstra(order[cnt]);	//cnt��° ���̱ⱸ�� �������� �ٽ� �Ÿ������ ���� ���̱ⱸ ����.
			printAttractionRoute();
			attractionInfo[order[cnt]].visit = 1;
			cnt++;
		}


		//0�Է��ϸ� �׳� ����
		else if (num == 0 && cnt < 10) {
			exit(0);
		}


		//cnt==10 �Ǹ� ���̱ⱸ �� ź�ɷ� �����ϰ� ����
		else if (cnt >= 10) {
			printf("���̱ⱸ �������~!~!~!");
			exit(0);
		}


		else {
			printf("���������,,,�̤�");
		}
	} while (1);

	return 0;
}