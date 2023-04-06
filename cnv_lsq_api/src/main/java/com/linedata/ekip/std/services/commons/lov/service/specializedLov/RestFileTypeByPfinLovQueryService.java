package com.linedata.ekip.std.services.commons.lov.service.specializedLov;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.std.converter.StringConverter;
import com.linedata.ekip.std.services.commons.lov.entity.DataMap;
import com.linedata.ekip.std.services.commons.lov.service.DefaultLovQueryService;

/**
 * @author MSMida
 */
public class RestFileTypeByPfinLovQueryService extends DefaultLovQueryService
{

   private final static String BEANID = "RestFileTypeByPfin";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public Object[] getParameters(ActionContext actionContext, String lovName, DataMap filters)
   {

      String productCodeHidden = null;
      // retrieving filters
      if (filters != null)
      {
         // criteria of search
         productCodeHidden = StringConverter.convertObjectToString(filters.get("productCodeHiddenFilter"));
      }

      // factoring object for sql request
      return new Object[]
      { productCodeHidden };
   }

}
