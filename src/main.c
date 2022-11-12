#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <limits.h>
#include <stdbool.h>
#include <time.h>

#define MAX 11	//10(놀이기구의 개수) + 1(시작위치)

//놀이기구의 위치
typedef struct location {
	double x;			//x축 위치
	double y;			//y축 위치
	double waiting;	//인기도
	char name[MAX];	//놀이기구 이름
}loca;

//route[i]: 출발지에서 i라는 놀이기구까지 드는 최소 거리와 그 놀이기구까지 도달하는데 거치는 놀이기구
typedef struct ROUTE {
	double distance;	//해당 node까지 갈때의 거리
	bool possible;		//i번째 놀이기구를 방문했는지 방문하지 않았는지 참거짓으로 저장
}route;

loca attractionInfo[MAX];	//놀이기구들의 위치 info[0]은 시작위치에 대한 값임.
route routeInfo[MAX];	//최소거리로 i번째 놀이기구에 방문하는 방법의 놀이기구 방문순서와 해당 node까지 드는 거리 계산한 것 저장
double edge[MAX][MAX];	//edge값 저장 2차원 배열
int order[MAX];	//방문한 놀이기구들을 순서대로 저장함.

double calEdge();	//위치 기준으로 거리 계산하는 함수
int minDistance();	//최소거리 계산함수
//void printSolution();
void dijkstra();	//다익스트라 알고리즘 수행

double calEdge() {

	for (int i = 0;i < MAX;i++) {
		attractionInfo[i].x = rand() % 100 + 1; //0-100까지의 범위에서 무작위로 정수값 하나 받아옴.
		attractionInfo[i].y = rand() % 100 + 1; //동일
		attractionInfo[i].waiting = rand() % 10 + 1; //놀이기구의 인기도
	}

	for (int i = 0;i < MAX;i++) {
		for (int j = 0;j < MAX;j++) {
			if (i == j) {
				edge[i][j] = 0;	//만약 i와 j가 동일하다면(a놀이기구에서 a놀이기구로 가는 값은 0) 0으로 초기화
			}
			else {
				edge[i][j] = sqrt(pow(attractionInfo[i].x - attractionInfo[j].x, 2) + pow(attractionInfo[i].y - attractionInfo[j].y, 2));	//i지점과 j지점의 거리계산 함수
			}
		}
	}
}

// shortest path tree에 아직 포함되지 않은 놀이기구들 중 가장 거리가 가까운 놀이기구를 찾는 함수
int minDistance()
{
	//비교를 위해 가장 작은 값 만들어줌
	int min = INT_MAX, min_index;

	//아직 방문하지 않은 노드이고, 거리가 제일 가까운 놀이기구라면 min_index값을 그 놀이기구의 값으로 바꿔줌.
	for (int v = 0; v < MAX; v++)
		if (routeInfo[v].possible == false && routeInfo[v].distance <= min)
			min = routeInfo[v].distance + attractionInfo[v].waiting, min_index = v;	//!!!!!!!!!!!!!!!!!!!!!!!!!여기에 waiting 들어가면 되는게 맞나??????????????????????????????

	//가장 가까운 놀이기구의 값 리턴
	return min_index;
}

// 결과값 출력 함수
void printSolution()
{
	printf("Vertex \t\t Distance from Source\n");
	for (int i = 0; i < MAX; i++) {
		printf("visit: ");
		for (int j = 0;j < MAX;j++) {
			printf("-> %d", order[j]);
		}
		printf("\n%d \t\t\t\t %lf\n", i, routeInfo[i].distance);
	}
}

void dijkstra(int src)
{
	//처음의 거리값 무한으로 초기화 && 아직 어떤 놀이기구에도 방문을 하지 않았으니 0으로 초기화.
	for (int i = 0; i < MAX; i++) {
		routeInfo[i].distance = INT_MAX;
		routeInfo[i].possible = false;
	}

	//출발지에서 출발지로 가는 거리는 0이므로 0으로 초기화
	routeInfo[src].distance = 0.0;

	//가장 짧은 거리 찾기
	for (int count = 0; count < MAX - 1; count++) {
		//놀이기구 집합에서 가장 작은 거리를 찾음.
		//첫번째 반복에서 u는 출발지의 의미를 지님
		//-> 출발지에서 출발지로 가는 거리를 0으로 초기화했기 때문에 첫번째 반복에서 min값은 당연하게 0임.
		int u = minDistance();

		routeInfo[u].possible = true;	//방문했으므로 값을 true로 바꿔줌.
		order[count] = u;	//방문한 놀이기구들을 저장.

		//방문한 놀이기구가 생겼으니 거리값을 수정해줌
		for (int v = 0; v < MAX; v++)
			//아직 방문을 안해서 possible값이 false일 때만 수정해줌! 
			// 또한 u에서 v까지 가는 값이 존재하고 
			// u를 통해서 출발지에서 v로 가는 길이 routeInfo[v]의 거리값보다 작을 때만 수정
			if (!routeInfo[v].possible && edge[u][v]
				&& routeInfo[u].distance != INT_MAX
				&& routeInfo[u].distance + edge[u][v] < routeInfo[v].distance)
				routeInfo[v].distance = routeInfo[u].distance + edge[u][v];
	}

	// print the constructed distance array
	printSolution();
}

int main() {
	calEdge();
	dijkstra(0);

	while (1) {
		int num;
		//1입력하면 다시 프로그램 실행
		scanf("%d", &num);

		if (num == 1) {
			//다시 랜덤으로 돌리고 다익스트라 알고리즘 처음부터 돌리는 코드임! 테이블 업데이트하는 코드 아님!!!!!!!!!
			calEdge();
			dijkstra(0);
		}
		//0입력하면 그냥 종료
		else if (num == 0) {
			exit(0);
		}
		else {
			printf("문제생긴듯,,,ㅜㅜ");
		}
	}

	return 0;
}


//수정된 값대로 테이블 업데이트하는 함수 만들어야 됨!!
//인기도 가중치 저기에 넣는게 맞는지 확인해야 됨!!