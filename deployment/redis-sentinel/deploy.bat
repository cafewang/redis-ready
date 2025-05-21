k3d cluster create redis-sentinel --agents 3
kubectl apply -f redis-config.yaml
kubectl apply -f redis-master.yaml
kubectl apply -f redis-rep1.yaml
kubectl apply -f redis-rep2.yaml
kubectl apply -f redis-sentinel-config.yaml
kubectl apply -f redis-sentinel-s0.yaml
kubectl apply -f redis-sentinel-s1.yaml
kubectl apply -f redis-sentinel-s2.yaml