package entitys;

import services.DantriGetContentService;
import services.VnExpressGetContentService;

public class FacadeService {
    public VnExpressGetContentService vnExpressGetContentService = new VnExpressGetContentService();
    public DantriGetContentService dantriGetContentService = new DantriGetContentService();
}
