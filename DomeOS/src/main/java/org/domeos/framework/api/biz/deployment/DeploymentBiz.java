package org.domeos.framework.api.biz.deployment;

import org.domeos.framework.api.biz.base.BaseBiz;
import org.domeos.framework.api.model.deployment.Deployment;
import org.domeos.framework.engine.exception.DaoException;

import java.util.List;

/**
 * Created by xxs on 15/12/19.
 */
public interface DeploymentBiz extends BaseBiz {

    void createDeployment(Deployment deployment);

    Deployment getDeployment(int id);

    void update(Deployment deployment) throws DaoException;

    List<Deployment> listDeploymentByClutesrId(int id);

//    /**
//     *
//     * @param deployId
//     * @return
//     * @throws IOException
//     */
//    Deployment getDeployment(long deployId) throws IOException;
//
//    /**
//     *
//     * @param deployName
//     * @return
//     */
//    Long getIdByName(String deployName);
//
//    /**
//     *
//     * @param deployment
//     * @return
//     */
//    long createDeployment(DeploymentDraft deployment) throws Exception;
//
//    /**
//     *
//     * @param deployId
//     */
//    void deleteDeployment(long deployId);
//
//    /**
//     *
//     * @param deployIds
//     * @return
//     */
//    List<Deployment> listDeployment(List<Long> deployIds);
//
//    /**
//     *
//     * @param deployId
//     * @param replicas
//     */
//    void updateDefaultReplicas(long deployId, int replicas);
}
