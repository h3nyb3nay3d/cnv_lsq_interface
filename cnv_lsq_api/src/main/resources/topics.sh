cd ../../../../cnv_lsq_kafka/
./bin/kafka-topics.sh --create --topic PENDING_ASYNC_DEALS_BY_DEAL_EXTERNAL_ID_TOPIC --bootstrap-server localhost:9093 --replication-factor 1 --partitions 3 --command-config ./config/client-ssl.properties
./bin/kafka-topics.sh --create --topic PENDING_ASYNC_DEALS_BY_TIERS_TOPIC --bootstrap-server localhost:9093 --replication-factor 1 --partitions 3 --command-config ./config/client-ssl.properties
./bin/kafka-topics.sh --create --topic PENDING_DRAWDOWNS_TOPIC --bootstrap-server localhost:9093 --replication-factor 1 --partitions 3 --command-config ./config/client-ssl.properties
./bin/kafka-topics.sh --create --topic STREAM_TOPIC --bootstrap-server localhost:9093 --replication-factor 1 --partitions 3 --command-config ./config/client-ssl.properties
./bin/kafka-topics.sh --create --topic REQUESTED_ASYNC_DEALS_TOPIC --bootstrap-server localhost:9093 --replication-factor 1 --partitions 3 --command-config ./config/client-ssl.properties
