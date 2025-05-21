k3d cluster create redis-replica -p "8081:30081@agent:0" -p "8082:30082@agent:0" -p "8083:30083@agent:0" --agents 3
kubectl apply -f redis-config.yaml
kubectl apply -f redis-master.yaml
kubectl apply -f redis-rep1.yaml
kubectl apply -f redis-rep2.yaml