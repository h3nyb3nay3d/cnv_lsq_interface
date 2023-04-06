package com.linedata.ekip.std.services.commons.lov.service.specializedLov;

import com.linedata.ekip.commons.shared.context.ActionContext;
import com.linedata.ekip.std.converter.StringConverter;
import com.linedata.ekip.std.services.commons.lov.entity.DataMap;
import com.linedata.ekip.std.services.commons.lov.service.DefaultLovQueryService;

/**
 * @author MSMida
 */
public class CaafRevLovQueryService extends DefaultLovQueryService
{

   private final static String BEANID = "CaafRev";

   @Override
   public String getBeanId()
   {
      return BEANID;
   }

   @Override
   public Object[] getParameters(ActionContext actionContext, String lovName, DataMap filters)
   {

      String partyId = null;
      // retrieving filters
      if (filters != null)
      {
         // criteria of search
         partyId = StringConverter.convertObjectToString(filters.get("PartyId"));
      }

      // factoring object for sql request
      return new Object[]
      { partyId };
   }

}
