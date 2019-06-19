#!/bin/sh -x

# Rotina responsável por 
#  1 - Baixa de arquivos remiessas
#  2 - Processamento das remessas de solicitação de validação de CPFs 
#  3 - Envio dos arquivos retornos com o stattus da validação do CPFs
#  Marcelo Rebeque
./download_remessas.sh
if [ $? -eq 0 ]; then

   java -cp  bui-1.0.0.0.jar:./libs/*:. br.gov.rj.fazenda.sati.app.Main
   if [ $? -eq 0 ]; then
  
      ./upload_retornos.sh
   fi
fi
