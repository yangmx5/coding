# coding

一个综合性的算法学习与面试准备仓库，包含 Java/Python 算法题解、Django 任务管理系统及面试训练材料。

## 仓库结构

```
coding/
├── java/           # Java 算法与面试题（244 个文件）
├── python/         # Python 算法实现
├── avengers/       # Django Web 应用（任务管理系统）
├── tools/          # 实用工具脚本
├── training/       # 训练与面试材料
├── docs/           # 文档
└── Trigger.xml     # 配置文件
```

---

## 一、Java 算法题解 (`java/`)

Java 目录共 **244 个文件**，按题目来源和算法类型分类整理。

### LeetCode 经典题 (`java/LeetCode/`)

| 文件 | 题目 | 算法 |
|------|------|------|
| `LongestValidParentheses.java` | 最长有效括号 | 动态规划 |
| `LongestPalindromicSubstring.java` | 最长回文子串 | 动态规划 |
| `EditDistance.java` | 编辑距离 | 动态规划 |
| `RegularExpressionMatches.java` | 正则表达式匹配 | 动态规划 |
| `DecodeWays.java` | 解码方法 | 动态规划 |
| `JumpGame.java` | 跳跃游戏 | 贪心/DP |
| `UniqueBinarySearchTrees.java` | 不同的二叉搜索树 | 动态规划 |
| `ScrambleString.java` | 扰乱字符串 | 动态规划 |
| `MaximalRectangle.java` | 最大矩形 | 栈 |
| `LargestRectangleinHistogram.java` | 柱状图中最大的矩形 | 栈 |
| `FindMedianSortedArrays.java` | 寻找两个正序数组的中位数 | 二分查找 |
| `LRU.java` | LRU 缓存 | 哈希表 + 链表 |
| `Rain.java` | 接雨水 | 双指针 |
| `PolishValue.java` | 逆波兰表达式 | 栈 |
| `ZigZagConversion.java` | Z 字形变换 | 字符串 |
| `ReverseInteger.java` | 整数反转 | 数学 |

### LeetCode Hot 100 (`java/hotOneHundred/`)

按算法类型细分：

- **动态规划 (`dp/`)**: MaxSubArray、RobCash、JumpGame、LowestCoinSum、MaxProfit、WordSplit、DifferentPathSum 等 18 道题
- **树 (`tree/`)**: BuildTree（根据前序/中序遍历重建二叉树）
- **回溯 (`backtracking/`)**: AllPaiLie（全排列）、CombinationSum（组合总和）
- **DFS/BFS (`dfsAndBfs/`)**: 图的遍历问题
- **排序 (`sort/`)**: 经典排序题变体
- **其他**: LRU、Trie、MinStack、GroupAnagrams、MergeIntervals、TopKSum 等

### 左程云算法教材题 (`java/Zuochengyun/`)

| 文件 | 题目 |
|------|------|
| `Problem_01_ParenthesesProblem.java` | 括号问题 |
| `Problem_02_Islands.java` | 岛屿数量（图遍历） |
| `Problem_02_SmallSum.java` | 小和问题（归并排序变体） |
| `Problem_02_LongestSubarrayLessSumAwesomeSolution.java` | 最长子数组累加和 |
| `Problem_03_CardsInLine.java` | 排成一条线的纸牌（博弈论） |
| `Problem_03_SubArrayMaxSum.java` | 子数组最大累加和 |
| `Problem_04_SubMatrixMaxSum.java` | 子矩阵最大累加和 |
| `Problem_04_MountainsAndFlames.java` | 山和火焰 |
| `Problem_01_TarjanAndDisjointSetsForLCA.java` | Tarjan + 并查集求 LCA |
| `Problem_01_ReverseStackUsingRecursive.java` | 递归逆转栈 |

### 公司面试真题 (`java/Com/`)

共收录 **74 道**来自国内知名互联网公司的面试真题：

| 公司 | 目录 |
|------|------|
| 阿里巴巴 | `aLi/` |
| 百度 | `baidu/` |
| 滴滴 | `didi/` |
| 京东 | `jingdong/` |
| 美团 | `meituan/` |
| 网易 | `wangyi/` |
| 拼多多 | `pinduoduo/` |
| 腾讯 | `Haikang/` |
| 今日头条 | `Toutiao/` |
| 搜狐 | `SouHu/` |
| 爱奇艺 | `aiqiyi/` |
| 去哪儿 | `Qunar/` |
| 小米 | `mi/` |
| 360 | `threesixzero/` |
| 蘑菇街 | `mogujie/` |
| 猪八戒 | `zhubajie/` |
| 万美 | `Wanmei/` |
| 搜狗 | `sougou/` |
| 携程 | `Xiecheng/` |
| 链家 | `Lianjia/` |
| 人人网 | `Renren/` |

### 剑指 Offer (`java/forwardoffer/`)

| 文件 | 题目 |
|------|------|
| `AllPaiLie.java` | 字符串的排列 |
| `Fibonacci.java` | 斐波那契数列 |
| `FrogJump.java` | 青蛙跳台阶 |
| `ReverseList.java` | 反转链表 |
| `ReverseSentence.java` | 翻转单词顺序 |
| `DeleteDuplication.java` | 删除链表中重复的节点 |
| `RebuildTree.java` | 重建二叉树 |
| `TheMaxAdd.java` | 最大子数组之和 |

### 其他目录

- **`base/`** — 基础数据结构与工具类
- **`common/`** — 通用算法
- **`hotBack/`** — 补充面试题
- **`excelTool/`** — Excel 文件处理工具
- **`maxadd/`** — 大数加法
- **`test/`** — 单元测试（反射、单例、XML 解析）
- **`aviator/`** — Maven 工程，使用 Aviator 表达式引擎（v4.2.9）与 JSONPath（v2.4.0）

---

## 二、Python 算法实现 (`python/`)

| 文件 | 内容 |
|------|------|
| `LRU.py` | LRU 缓存（列表 + 字典实现） |
| `LongestValidParentheses.py` | 最长有效括号（动态规划） |
| `SortArrayMiddleNum.py` | 排序与中位数查找 |
| `hanoi.py` | 汉诺塔 |
| `printMatrix.py` | 矩阵螺旋打印 |
| `threeZero.py` | 三个零模式查找 |
| `base/BinarySearch.py` | 二分查找 |
| `base/QuickSort.py` | 快速排序 |
| `base/dfs.py` | 深度优先搜索 |

---

## 三、Django 任务管理系统 (`avengers/`)

基于 **Django 2.2.5** 构建的 Web 应用，用于管理学习任务和富文本内容。

### 技术栈

| 依赖 | 版本 | 用途 |
|------|------|------|
| Django | 2.2.5 | Web 框架 |
| Django REST Framework | 3.10.2 | RESTful API |
| Django CKEditor | 5.9.0 | 富文本编辑器 |
| BeautifulSoup4 | 4.8.0 | HTML 解析/爬虫 |
| Requests | 2.22.0 | HTTP 请求 |
| PyYAML | 5.3 | YAML 解析 |
| Jieba | — | 中文分词 |

### 核心模型

**`engine` 应用**（任务管理）：

```python
class Task(models.Model):
    title           # 任务标题
    desc            # 富文本描述（CKEditor）
    status          # 状态（整数）
    is_important    # 是否重要
    is_urgent       # 是否紧急
    user            # 关联用户
    active          # 是否有效
    plan_time       # 计划时间
    plan_start_time # 计划开始时间
    plan_end_time   # 计划截止时间
    task_type       # 任务类型

class TaskItem(models.Model):
    content   # 子任务内容
    status    # 状态
    task      # 关联父任务（外键）
    active    # 是否有效
    plan_time # 计划时间
```

**`ancestor` 应用**（资源管理）：`RichResource` 模型（富文本资源）

### 项目结构

```
avengers/axe/
├── manage.py
├── axe/          # 项目配置（settings, urls）
├── engine/       # 任务管理应用
├── ancestor/     # 资源管理应用
├── surface/      # 前端静态资源
├── conf/         # 额外配置
├── deploy/       # 部署脚本
└── test_app/     # 测试模块
```

---

## 四、工具脚本 (`tools/`)

| 文件 | 功能 |
|------|------|
| `diffJsons.py` | JSON 文件对比工具 |
| `validParentheses.py` | 括号合法性校验 |

---

## 五、训练材料 (`training/`)

- **`Part4.txt`** — 分布式系统面试场景：支付重试幂等性问题解决方案
  - 幂等键（Idempotent Key）设计
  - 可串行化事务隔离级别
  - `SELECT FOR UPDATE` 行锁
  - 分布式锁
  - 异步队列处理

---

## 六、涉及算法与数据结构总览

### 数据结构
- **Trie**（前缀树）
- **LRU Cache**（双向链表 + 哈希表）
- **Binary Tree / BST**
- **Graph**（邻接表/矩阵）
- **Stack / Queue / Deque**
- **Disjoint Set**（并查集）

### 算法
- **动态规划**: 最长公共子序列、背包问题、最大子数组、股票买卖等
- **图算法**: DFS、BFS、Tarjan（强连通分量/LCA）
- **回溯**: 全排列、组合总和
- **排序**: 快速排序、归并排序（含逆序对统计）
- **二分查找**: 有序数组、旋转数组搜索
- **字符串**: 正则匹配、括号匹配、回文检测、Z 字形变换
- **数学**: 汉诺塔、斐波那契、大数加法

---

## 七、构建与运行

### Java（Maven 子项目）

```bash
cd java/aviator
mvn clean package
```

### Python / Django

```bash
cd avengers/axe
pip install -r ../requirement.txt
python manage.py runserver
```

### 编码转换工具

```bash
cd java
bash convert2utf-8.sh
```

---

## 八、统计信息

| 类别 | 数量 |
|------|------|
| Java 文件 | 244 |
| Python 文件 | 9 |
| LeetCode 题解 | 20+ |
| Hot 100 题解 | 25+ |
| 公司面试真题 | 74+ |
| 剑指 Offer 题 | 8 |
| 左程云教材题 | 10+ |
| Django 模型 | 2（Task, TaskItem） |
