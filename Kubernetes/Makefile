.PHONY: start_kind_cluster, stop_kind_cluster, add_nginx_ingress, install_app, remove_app

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
	helm uninstall uow-cca-groupt-hc