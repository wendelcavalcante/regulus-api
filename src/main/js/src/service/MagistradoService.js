import { regulus_api } from "../http-common";

export const MagistradoDataService = {
    getAllMagistrados() {
        return regulus_api.get("/magistrados");
    },
    async updateMagistrado(magistrado) {
        return await regulus_api.post("/update_magistrado", magistrado);
    },
    async sendMailIndicacao(matricula) {
        return await regulus_api.post("/send_mail_indicacao", { matricula: matricula });
    }
}