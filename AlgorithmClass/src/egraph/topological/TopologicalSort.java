package egraph.topological;

import java.util.*;
public class TopologicalSort {
	int N;  					// 그래프의 정점 수
	boolean[] visited;   		// DFS 수행 중 방문여부 체크 용
	List<Integer>[] adjList;  	// 인접리스트 형태의 입력 그래프
	List<Integer> sequence;  	// 위상 정렬 순서를 담을 리스트
	
	public TopologicalSort(List<Integer>[] graph) {  //생성자
		N = graph.length;
		visited = new boolean[N]; 
		adjList = graph;
		sequence = new ArrayList<>();
	}
	
	//***************************************************************
	public List<Integer> tsort() {     // 위상정렬을 위한 DFS 수행
		
		
		return sequence;
	}
	
	//***************************************************************
	public void dfs(int i) { // DFS 수행
		
		
	}
}
