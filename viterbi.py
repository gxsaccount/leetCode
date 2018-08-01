import numpy as np
#单词的各个标记发射sorce
feats=[[-0.2095,  0.1737, -0.3876,  0.4378, -0.3475],
        [-0.2681,  0.1620, -0.4196,  0.4297, -0.2857],
        [-0.3868,  0.2700, -0.4559,  0.3874, -0.2614],
        [-0.3761,  0.2536, -0.3897,  0.4786, -0.2404],
        [-0.3446,  0.1833, -0.4204,  0.4936, -0.0980],
        [-0.2738,  0.2778, -0.3540,  0.4534, -0.3920],
        [-0.2207,  0.2085, -0.4019,  0.3099, -0.6957],
        [-0.3363,  0.2813, -0.4552,  0.3353, -0.3985],
        [-0.3904,  0.0843, -0.5000,  0.3937, -0.2078],
        [-0.2801,  0.2033, -0.4282,  0.4708, -0.0854],
        [-0.2504,  0.3018, -0.3046,  0.4671, -0.5199]]
#标记之间转移sorce
trans=[[    -0.1181,     -1.4420,     -1.1108,     -1.1187, -10000.0000],
        [    -0.4957,     -0.1970,     -0.0334,      1.4273, -10000.0000],
        [    -0.7531,     -0.4319,      0.6693,      0.6505, -10000.0000],
        [-10000.0000, -10000.0000, -10000.0000, -10000.0000, -10000.0000],
        [     0.1857,     -0.2764,     -0.5939,     -0.3061, -10000.0000]]

#标记
tag_to_ix={'B': 0, 'I': 1, 'O': 2, '<START>': 3, '<STOP>': 4}
START='<START>'
END='<STOP>'

#正确答案
path_reslut=[1,2,2,2,2,2,2,2,2,2,1]
sore_reslut=[2.6907]

def viterbi(feats,trans,tag_to_ix):
    feats=np.array(feats)
    trans=np.array(trans)
    path=[]
    sore=[]
    backpointers=[]#backpointer[i][j] 是指在i时刻到达j的最优路径的前一个节点是backpointer[i][j]
    #初始化start位置为0，forward_var=[-10000.,10000,-10000,0,-10000]
    init_vtb_var=np.zeros([len(tag_to_ix)])-10000.
    init_vtb_var[tag_to_ix[START]]=0
    forward_var=init_vtb_var
    for feat in feats:
        backpointers_t=np.array([],dtype=np.int32) #当前时刻的backpointer
        viterbivars_t=np.array([]) #当前时刻的vter变量
        for next_tag in range(len(tag_to_ix)):
            #找到当前状态为next_tag，转移到next_tag最优的节点（best_tag_id）
            next_tag_var = forward_var + trans[next_tag]
            best_tag_id = np.argmax(next_tag_var)
            backpointers_t=np.append(backpointers_t,best_tag_id)
            viterbivars_t=np.append(viterbivars_t,next_tag_var[best_tag_id])
        forward_var = viterbivars_t+feat
        backpointers.append(backpointers_t)
    terminal_var = forward_var + trans[tag_to_ix[END]]
    best_tag_id = np.argmax(terminal_var)
    path_score = terminal_var[best_tag_id]
    
    #解码
    best_path = [best_tag_id]
    for backpointers_t in reversed(backpointers):
        best_tag_id = backpointers_t[best_tag_id]
        best_path.append(best_tag_id)
    start = best_path.pop()
    assert start == tag_to_ix[START]
    best_path.reverse()
    return path_score, best_path
print(viterbi(feats,trans,tag_to_ix))


