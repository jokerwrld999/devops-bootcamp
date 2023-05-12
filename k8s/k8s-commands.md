kubectl get nodes
kubectl get pod
kubectl get services

kubectl create deployment nginx-deploy --image=nginx
kubectl get deployment
kubectl get replicaset

kubectl edit deployment nginx-deploy

kubectl logs
kubectl describe pod

kubectl exec -it [pod_name] -- bin/bash

kubectl delete deployment nginx-deploy

kubectl apply -f nginx-deploy.yml
kubectl delete -f nginx-deploy.yml