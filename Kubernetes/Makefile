.PHONY: start_kind_cluster, stop_kind_cluster

start_kind_cluster:
	./kind create cluster --name uow-cca-groupt && \
	kubectl get nodes

stop_kind_cluster:
	./kind delete cluster --name uow-cca-groupt