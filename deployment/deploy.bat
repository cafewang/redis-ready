k3d cluster create redis-example -p "8081:30081@agent:0" --agents 2
kubectl apply -f redis-config.yaml
kubectl apply -f redis-deployment.yaml