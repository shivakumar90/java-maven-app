export IMAGE_NAME = $1
docker-compose -f docker-compose.yaml up -d
echo "success"
