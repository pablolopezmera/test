/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ec.virtualcoin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * @author Liferay
 */
@Component(
	immediate = true,
	property = {
		"osgi.http.whiteboard.context.path=/",
		"osgi.http.whiteboard.servlet.pattern=/profile/image/*"
	},
	service = Servlet.class
)
public class ImageServlet extends HttpServlet {

    private static Logger _log = LoggerFactory.getLogger(ImageServlet.class.getName());

    @Override
	public void init() throws ServletException {
		_log.info("BladeServlet init");

		super.init();
	}

	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	    
	    try {
	        _log.info((String)request.getParameter("imageType"));
	        ImageType imageType = ImageType.valueOf((String)request.getParameter("imageType"));
            _log.info(request.getParameter("file"));
            String fileName = request.getParameter("file");
            _log.info(imageType.toString());
            User user = PortalUtil.getUser(request);
            _log.info(user.getScreenName());
            response.setContentType("image/jpeg");

            FileUtil fileUtil = new FileUtil();
            String screenName = PortalUtil.getUser(request).getScreenName();
            String profileFolderLocation = PropsUtil.get(Constants.PROFILE_FOLDER_LOCATION.getPropertyName());
            String pathToWeb = fileUtil.generateRoute(screenName, imageType, profileFolderLocation, fileUtil.getFileExtension(fileName));
            _log.info(pathToWeb);
            File f = new File(pathToWeb);
            if (!f.exists()) {
                _log.info("Archivo no existe: ".concat(pathToWeb));
                f = new File(PropsUtil.get(Constants.PROFILE_DEFAULT_IMAGE.getPropertyName()));
            }
            BufferedImage bi = ImageIO.read(f);
            OutputStream out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.close();
        } catch (PortalException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	private static final long serialVersionUID = 1L;

}