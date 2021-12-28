.PHONY: start_kind_cluster, stop_kind_cluster, add_nginx_ingress, install_app, remove_app, get_ingress, install_ingress

start_kind_cluster:
	./kind create cluster --name uow-cca-groupt --config=kind-config.yaml && \
	kubectl get nodes

stop_kind_cluster:
	./kind delete cluster --name uow-cca-groupt

add_nginx_ingress:
	kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/kind/deploy.yaml

install_app:
	helm upgrade --atomic --install uow-cca-groupt-hc ./uow-cca-groupt-hc -n iit

remove_app:
	helm uninstall uow-cca-groupt-hc -n iit

install_ingress:
	helm upgrade --install ingress-nginx ingress-nginx \
		--repo https://kubernetes.github.io/ingress-nginx \
		--namespace ingress-nginx --create-namespace

get_ingress:
	kubectl --namespace ingress-nginx get services -o wide -w ingress-nginx-controller