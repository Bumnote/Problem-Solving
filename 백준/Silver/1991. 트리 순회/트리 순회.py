from sys import stdin

input = stdin.readline


class Node:
    def __init__(self, data, left_node, right_node):
        self.data = data
        self.left_node = left_node
        self.right_node = right_node


# 전순위(preorder) 탐방: D -> L -> R
def pre_order(node):
    print(node.data, end="")
    if node.left_node != None:
        pre_order(tree[node.left_node])
    if node.right_node != None:
        pre_order(tree[node.right_node])


# 중순위(inorder) 탐방: L -> D -> R
def in_order(node):
    if node.left_node != None:
        in_order(tree[node.left_node])
    print(node.data, end="")
    if node.right_node != None:
        in_order(tree[node.right_node])


# 후순위(postorder) 탐방: L -> R -> D
def post_order(node):
    if node.left_node != None:
        post_order(tree[node.left_node])
    if node.right_node != None:
        post_order(tree[node.right_node])
    print(node.data, end="")


## 변수 입력 부분 ##
n = int(input().strip())
tree = {}

## 문제 해결 부분 ## 
for _ in range(n):
    data, left_node, right_node = input().split()
    if left_node == ".":
        left_node = None
    if right_node == ".":
        right_node = None
    tree[data] = Node(data, left_node, right_node)

pre_order(tree["A"])
print()
in_order(tree["A"])
print()
post_order(tree["A"])
